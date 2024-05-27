package com.nataly.test_task.service;

import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.mapper.ToApplicationByInn;
import com.nataly.test_task.model.ApplicationEntity;

public interface ApplicationService {

    void saveApplication(ApplicationDto applicationDto);

    ApplicationDto findApplication(String inn);

    @ToApplicationByInn
    ApplicationEntity findApplicationEntity(String inn);
}
