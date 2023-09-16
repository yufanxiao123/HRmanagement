package net.javaguide.departmentservice.mapper;

import javax.annotation.processing.Generated;
import net.javaguide.departmentservice.dto.DepartmentDto;
import net.javaguide.departmentservice.entity.Department;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T13:20:01+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class AutoDepartmentMapperImpl implements AutoDepartmentMapper {

    @Override
    public DepartmentDto mapToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setDepartmentDescription( department.getDepartmentDescription() );
        departmentDto.setDepartmentCode( department.getDepartmentCode() );

        return departmentDto;
    }

    @Override
    public Department mapToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setDepartmentName( departmentDto.getDepartmentName() );
        department.setDepartmentDescription( departmentDto.getDepartmentDescription() );
        department.setDepartmentCode( departmentDto.getDepartmentCode() );

        return department;
    }
}
