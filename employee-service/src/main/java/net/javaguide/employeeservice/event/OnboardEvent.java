package net.javaguide.employeeservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguide.employeeservice.dto.EmployeeDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardEvent {
   private String message;
   private String status;
   private EmployeeDto employeeDto;
}