package net.javaguide.employeeservice.mapper;

import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//有了@Mapper  mapstruct有自己的implementation，map的类 变量名和类型最好一样
@Mapper
public interface AutoEmployeeMapper {
   AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
   //生成对象，用MAPPER来call methods
   @Mapping(source = "email",target = "emailAddress") //如果有变量名不一样的地方，需要用@Mapping明确
   EmployeeDto mapToEmployeeDto(Employee employee);
   @Mapping(source = "emailAddress",target = "email")
   Employee mapToEmployee(EmployeeDto employeeDto);

}
