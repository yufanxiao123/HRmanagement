package net.javaguide.employeeservice.mapper;

import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.entity.Employee;

public class EmployeeMapper {
   public static EmployeeDto mapToEmployeeDto(Employee employee) {
      if (employee==null) {
         return null;
      }
      EmployeeDto employeeDto = new EmployeeDto(
              employee.getId(),
              employee.getFirstName(),
              employee.getLastName(),
              employee.getEmail(),
              employee.getDepartmentCode(),
              employee.getOrganizationCode()
      );
      return employeeDto;
   }

   public static Employee mapToEmployee(EmployeeDto employeeDto) {
      if(employeeDto==null) {
         return null;
      }
      Employee employee = new Employee(
              employeeDto.getId(),
              employeeDto.getFirstName(),
              employeeDto.getLastName(),
              employeeDto.getEmailAddress(),
              employeeDto.getDepartmentCode(),
              employeeDto.getOrganizationCode()
      );
      return employee;
   }
}
