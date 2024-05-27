package com.nataly.test_task.service.impl;

import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.exceptions.DataNotFoundException;
import com.nataly.test_task.mapper.ApplicationMapper;
import com.nataly.test_task.mapper.ToApplicationByInn;
import com.nataly.test_task.model.ApplicationEntity;
import com.nataly.test_task.repositry.ApplicationRepository;
import com.nataly.test_task.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;
    private final ApplicationMapper mapper;

    @Override
    public void saveApplication(ApplicationDto applicationDto) {
        repository.save(mapper.toApplicationEntity(applicationDto));
    }

    @Override
    public ApplicationDto findApplication(String inn) {
        return mapper.toApplicationDto(repository.findByInn(inn).orElseThrow(() -> new DataNotFoundException("Application with inn " + inn + " not found")));
    }

    @Override
    @ToApplicationByInn
    public ApplicationEntity findApplicationEntity(String inn) {
        return repository.findByInn(inn).orElseThrow(() -> new DataNotFoundException("Application with inn " + inn + " not found"));
    }
}
