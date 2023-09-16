package net.javaguide.orginazationservice.mapper;

import net.javaguide.orginazationservice.dto.OrganizationDto;
import net.javaguide.orginazationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoOrganizationMapper {
   AutoOrganizationMapper MAPPER = Mappers.getMapper(AutoOrganizationMapper.class);

   OrganizationDto mapToOrganizationDto(Organization organization);
   Organization mapToOrganization(OrganizationDto organizationDto);
}
