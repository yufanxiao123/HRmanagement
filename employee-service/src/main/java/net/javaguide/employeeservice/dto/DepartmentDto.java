package net.javaguide.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

//RESTful API of employee will call apis from department service
public class DepartmentDto {
   private Long id;
   private String departmentName;
   private String departmentDescription;
   private String departmentCode;
}