package com.nataly.test_task.service;

import com.nataly.test_task.dto.ApplicationDecisionDto;

public interface ApplicationDecisionService {

    void saveApplicationDecision(ApplicationDecisionDto applicationDecisionDto);

    ApplicationDecisionDto findDecision(String inn);
}
