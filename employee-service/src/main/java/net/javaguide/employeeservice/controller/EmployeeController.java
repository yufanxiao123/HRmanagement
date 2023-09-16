package net.javaguide.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguide.employeeservice.dto.APIResponseDto;
import net.javaguide.employeeservice.dto.EmployeeDto;
import net.javaguide.employeeservice.event.OnboardEvent;
//import net.javaguide.employeeservice.kafka.EmployeeProducer;
import net.javaguide.employeeservice.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.javaguide.employeeservice.rabbitmqpublisher.EmployeeProducerRabbitMQ;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

   private EmployeeServiceImpl employeeService;
   //private EmployeeProducer employeeProducer;
   private EmployeeProducerRabbitMQ employeeProducerRabbitMQ;

   @PostMapping
   public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
      OnboardEvent onboardEvent = new OnboardEvent();
      onboardEvent.setEmployeeDto(employeeDto);
      onboardEvent.setStatus("Probationary period");
      onboardEvent.setMessage("New employee join in");
      EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
      //employeeProducer.sendMessage(onboardEvent);
      employeeProducerRabbitMQ.sendMessage(onboardEvent);
      return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
   public ResponseEntity<APIResponseDto> findEmployeeById(@PathVariable("id") long id) {
      APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
      return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
   }

   //ExceptionHandler用来handle特定的exception类型，并且给客户端发送response

}