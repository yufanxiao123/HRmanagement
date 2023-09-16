package net.javaguide.employeeservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
   private long id;
   private String firstName;
   private String lastName;
   private String emailAddress;
   private String departmentCode;
   private String organizationCode;
}
