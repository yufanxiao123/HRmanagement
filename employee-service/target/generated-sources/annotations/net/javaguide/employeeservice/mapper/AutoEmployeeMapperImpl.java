package net.javaguide.employeeservice.mapper;

import javax.annotation.processing.Generated;
import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.entity.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T00:07:21+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class AutoEmployeeMapperImpl implements AutoEmployeeMapper {

    @Override
    public EmployeeDto mapToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmailAddress( employee.getEmail() );
        employeeDto.setId( employee.getId() );
        employeeDto.setFirstName( employee.getFirstName() );
        employeeDto.setLastName( employee.getLastName() );
        employeeDto.setDepartmentCode( employee.getDepartmentCode() );
        employeeDto.setOrganizationCode( employee.getOrganizationCode() );

        return employeeDto;
    }

    @Override
    public Employee mapToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.email( employeeDto.getEmailAddress() );
        employee.id( employeeDto.getId() );
        employee.firstName( employeeDto.getFirstName() );
        employee.lastName( employeeDto.getLastName() );
        employee.departmentCode( employeeDto.getDepartmentCode() );
        employee.organizationCode( employeeDto.getOrganizationCode() );

        return employee.build();
    }
}
