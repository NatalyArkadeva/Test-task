package com.nataly.test_task.mapper;

import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.model.ApplicationEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ApplicationMapper {

    @Mapping(target = "id", ignore = true)
    ApplicationEntity toApplicationEntity(ApplicationDto applicationDto);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    ApplicationDto toApplicationDto(ApplicationEntity entity);
}
