package net.javaguide.employeeservice.service;

import net.javaguide.employeeservice.dto.APIResponseDto;
import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
   EmployeeDto saveEmployee(EmployeeDto employeeDto);
   APIResponseDto getEmployeeById(long id);
}
