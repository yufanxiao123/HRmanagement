package net.javaguide.orginazationservice.mapper;

import javax.annotation.processing.Generated;
import net.javaguide.orginazationservice.dto.OrganizationDto;
import net.javaguide.orginazationservice.entity.Organization;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T13:07:19+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class AutoOrganizationMapperImpl implements AutoOrganizationMapper {

    @Override
    public OrganizationDto mapToOrganizationDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( organization.getId() );
        organizationDto.setOrganizationName( organization.getOrganizationName() );
        organizationDto.setOrganizationDescription( organization.getOrganizationDescription() );
        organizationDto.setOrganizationCode( organization.getOrganizationCode() );
        organizationDto.setCreatedDate( organization.getCreatedDate() );

        return organizationDto;
    }

    @Override
    public Organization mapToOrganization(OrganizationDto organizationDto) {
        if ( organizationDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setId( organizationDto.getId() );
        organization.setOrganizationName( organizationDto.getOrganizationName() );
        organization.setOrganizationDescription( organizationDto.getOrganizationDescription() );
        organization.setOrganizationCode( organizationDto.getOrganizationCode() );
        organization.setCreatedDate( organizationDto.getCreatedDate() );

        return organization;
    }
}
