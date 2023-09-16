package net.javaguide.orginazationservice.service;

import lombok.AllArgsConstructor;
import net.javaguide.orginazationservice.dto.OrganizationDto;
import net.javaguide.orginazationservice.entity.Organization;
import net.javaguide.orginazationservice.mapper.AutoOrganizationMapper;
import net.javaguide.orginazationservice.reposity.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

   private OrganizationRepository organizationRepository;
   @Override
   public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
      Organization organization = AutoOrganizationMapper.MAPPER.mapToOrganization(organizationDto);
      Organization savedOrganization = organizationRepository.save(organization);
      return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(organization);
   }

   @Override
   public OrganizationDto getOrganizationByCode(String code) {
      Organization organization = organizationRepository.findByOrganizationCode(code);
      return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(organization);
   }
}
