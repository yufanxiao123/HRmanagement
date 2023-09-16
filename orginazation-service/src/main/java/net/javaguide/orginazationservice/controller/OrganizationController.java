package net.javaguide.orginazationservice.controller;

import lombok.AllArgsConstructor;
import net.javaguide.orginazationservice.dto.OrganizationDto;
import net.javaguide.orginazationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
   private OrganizationService organizationService;

   @PostMapping
   public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
      OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
      return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
   }

   @GetMapping("/{code}")
   public ResponseEntity<OrganizationDto> findOrganizationByCode(@PathVariable("code") String code){
      OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
      return new ResponseEntity<>(organizationDto,HttpStatus.OK);
   }
}
