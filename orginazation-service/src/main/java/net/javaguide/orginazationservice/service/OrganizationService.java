package net.javaguide.orginazationservice.service;


import net.javaguide.orginazationservice.dto.OrganizationDto;

public interface OrganizationService {
   OrganizationDto saveOrganization(OrganizationDto organizationDto);

   OrganizationDto getOrganizationByCode(String code);

}
