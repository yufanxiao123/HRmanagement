package net.javaguide.departmentservice.service;

import net.javaguide.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
   DepartmentDto saveDepartment(DepartmentDto departmentDto);

   DepartmentDto getDepartmentByCode(String code);
}
