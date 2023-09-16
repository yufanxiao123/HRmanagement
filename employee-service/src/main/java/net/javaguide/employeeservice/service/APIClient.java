package net.javaguide.employeeservice.service;

import net.javaguide.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")//open feign有自己的implementation
@FeignClient(name = "DEPARTMENT-SERVICE")//有了server registry后的写法，作为Eureka Client, 会自己调用loadbalancer
public interface APIClient {
   @GetMapping("/api/departments/{code}")
   DepartmentDto getByDepartmentCode(@PathVariable("code") String code);
}
