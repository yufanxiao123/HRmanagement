package net.javaguide.departmentservice.mapper;

import net.javaguide.departmentservice.dto.DepartmentDto;
import net.javaguide.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
   AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);
   //生成对象，用MAPPER来call methods
   DepartmentDto mapToDepartmentDto(Department department);
   Department mapToDepartment(DepartmentDto departmentDto);
}
