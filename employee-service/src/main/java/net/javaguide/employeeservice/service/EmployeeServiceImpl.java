package net.javaguide.employeeservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguide.employeeservice.dto.APIResponseDto;
import net.javaguide.employeeservice.dto.DepartmentDto;
import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.dto.OrganizationDto;
import net.javaguide.employeeservice.entity.Employee;
import net.javaguide.employeeservice.exception.EmailAlreadyExistsException;
import net.javaguide.employeeservice.exception.ResourceNotFoundException;
import net.javaguide.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguide.employeeservice.mapper.EmployeeMapper;
import net.javaguide.employeeservice.reposity.EmployeeRepository;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   //有constructor，就不用@Autowired
   private EmployeeRepository employeeRepository;
   //private ModelMapper modelMapper;
   //private RestTemplate restTemplate; //用于和其他service同步沟通
   private WebClient webClient;
   private APIClient apiClient;

   //for Retry
   private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
   @Override
   public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
      //Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
      //Employee employee = modelMapper.map(employeeDto,Employee.class);
      Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmailAddress());
      if(optionalEmployee.isPresent()) {
         throw new EmailAlreadyExistsException("Email already exists for employee");
      }
      Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
      Employee savedEmployee = employeeRepository.save(employee);
      //return modelMapper.map(savedEmployee,EmployeeDto.class);
      return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
   }

   //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
   @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
   @Override
   public APIResponseDto getEmployeeById(long id) {
      LOGGER.info("inside getEmployeeById");
      Employee employee = employeeRepository.findById(id).orElseThrow(
              ()-> new ResourceNotFoundException("User","id",id)
      );//Throw 的exception会被调用这个函数的函数获取，即在controller里面

      //call api from url, 第二个参数是返回的类型
      //ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
      //        "http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
      //        DepartmentDto.class);
      //DepartmentDto departmentDto = responseEntity.getBody();

      //DepartmentDto departmentDto = webClient.get()
      //        .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
      //        .retrieve()
      //        .bodyToMono(DepartmentDto.class)
      //        .block();

      DepartmentDto departmentDto = apiClient.getByDepartmentCode(employee.getDepartmentCode());
      OrganizationDto organizationDto = webClient.get()
              .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
              .retrieve()
              .bodyToMono(OrganizationDto.class)
              .block();
      APIResponseDto apiResponseDto = new APIResponseDto();
      //apiResponseDto.setEmployeeDto(EmployeeMapper.mapToEmployeeDto(employee));
      apiResponseDto.setEmployeeDto(AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee));
      apiResponseDto.setDepartmentDto(departmentDto);
      apiResponseDto.setOrganizationDto(organizationDto);
      return apiResponseDto;
   }

   public APIResponseDto getDefaultDepartment(long id,Exception e) {
      LOGGER.info("inside getEmployeeById default method");
      Employee employee = employeeRepository.findById(id).get();
      DepartmentDto departmentDto = new DepartmentDto();
      departmentDto.setDepartmentCode("000");
      departmentDto.setDepartmentName("default department");
      departmentDto.setDepartmentDescription("default department description");
      OrganizationDto organizationDto = new OrganizationDto();
      organizationDto.setOrganizationCode("000");
      organizationDto.setOrganizationName("default organization");
      organizationDto.setOrganizationDescription("default organization description");
      APIResponseDto apiResponseDto = new APIResponseDto();
      apiResponseDto.setEmployeeDto(AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee));
      apiResponseDto.setDepartmentDto(departmentDto);
      apiResponseDto.setOrganizationDto(organizationDto);
      return apiResponseDto;
   }
}