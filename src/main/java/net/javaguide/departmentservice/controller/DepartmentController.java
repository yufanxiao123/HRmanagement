package net.javaguide.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguide.departmentservice.dto.DepartmentDto;
import net.javaguide.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
   private DepartmentService departmentService;

   @PostMapping
   private ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
      DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
      return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
   }

   @GetMapping("/{code}")
   private ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable("code") String code) {
      DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
      return new ResponseEntity<>(departmentDto,HttpStatus.OK);
   }
}
