package com.nataly.test_task.service.impl;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.exceptions.DataNotFoundException;
import com.nataly.test_task.mapper.ApplicationDecisionMapper;
import com.nataly.test_task.repositry.ApplicationDecisionRepository;
import com.nataly.test_task.service.ApplicationDecisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationDecisionServiceImpl implements ApplicationDecisionService {

    private final ApplicationDecisionRepository repository;
    private final ApplicationDecisionMapper mapper;

    @Override
    public void saveApplicationDecision(ApplicationDecisionDto applicationDecisionDto) {
        repository.save(mapper.toApplicationDecisionEntity(applicationDecisionDto));
    }

    @Override
    public ApplicationDecisionDto findDecision(String inn) {
        return mapper.toApplicationDecisionDto(repository.findByApplicationInn(inn).orElseThrow(() -> new DataNotFoundException("Application with inn " + inn + " not found")));
    }
}
