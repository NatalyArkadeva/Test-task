package com.nataly.test_task.process.impl;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.process.ExecutionProcess;
import com.nataly.test_task.process.StartDecisionProcess;
import com.nataly.test_task.service.ApplicationDecisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExecutionProcessImpl implements ExecutionProcess {

    private final StartDecisionProcess startDecisionProcess;
    private final ApplicationDecisionService applicationDecisionService;

    @Override
    public ApplicationDecisionDto execute(ApplicationDto applicationDto) {
        startDecisionProcess.startProcess(applicationDto);

        return applicationDecisionService.findDecision(applicationDto.inn());
    }
}
