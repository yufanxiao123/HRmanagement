package net.javaguide.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguide.departmentservice.dto.DepartmentDto;
import net.javaguide.departmentservice.entity.Department;
import net.javaguide.departmentservice.mapper.AutoDepartmentMapper;
import net.javaguide.departmentservice.mapper.DepartmentMapper;
import net.javaguide.departmentservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
   private DepartmentRepository departmentRepository;
   private ModelMapper modelMapper;
   @Override
   public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
      //Department department = DepartmentMapper.mapToDepartment(departmentDto);
      //Department department = modelMapper.map(departmentDto,Department.class);
      Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
      Department savedDepartment = departmentRepository.save(department);
      //DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
      //DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);
      DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
      return savedDepartmentDto;
   }

   @Override
   public DepartmentDto getDepartmentByCode(String code) {
      Department department = departmentRepository.findByDepartmentCode(code);
      //return DepartmentMapper.mapToDepartmentDto(department);
      //return modelMapper.map(department,DepartmentDto.class);
      return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
   }
}
