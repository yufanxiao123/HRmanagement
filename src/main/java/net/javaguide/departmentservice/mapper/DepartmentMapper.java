package net.javaguide.departmentservice.mapper;

import net.javaguide.departmentservice.dto.DepartmentDto;
import net.javaguide.departmentservice.entity.Department;

public class DepartmentMapper {
   public static DepartmentDto mapToDepartmentDto(Department department) {
      if (department==null) {
         return null;
      }
      DepartmentDto departmentDto = new DepartmentDto(
              department.getId(),
              department.getDepartmentName(),
              department.getDepartmentDescription(),
              department.getDepartmentCode()
      );
      return departmentDto;
   }

   public static Department mapToDepartment(DepartmentDto departmentDto) {
      if(departmentDto==null) {
         return null;
      }
      Department department = new Department(
              departmentDto.getId(),
              departmentDto.getDepartmentName(),
              departmentDto.getDepartmentDescription(),
              departmentDto.getDepartmentCode()
      );
      return department;
   }
}
