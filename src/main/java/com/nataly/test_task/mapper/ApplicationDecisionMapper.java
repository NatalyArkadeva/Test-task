package com.nataly.test_task.mapper;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.model.ApplicationDecisionEntity;
import com.nataly.test_task.service.ApplicationService;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {ToApplicationByInn.class, ApplicationService.class}
)
public interface ApplicationDecisionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "application", source = "inn", qualifiedBy = ToApplicationByInn.class)
    ApplicationDecisionEntity toApplicationDecisionEntity(ApplicationDecisionDto decisionDto);

    @Mapping(target = "inn", source = "application.inn")
    @BeanMapping(ignoreUnmappedSourceProperties = {"id", "application"})
    ApplicationDecisionDto toApplicationDecisionDto(ApplicationDecisionEntity entity);
}
