package com.nataly.test_task.process;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.service.ApplicationDecisionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class SaveDecisionProcess implements JavaDelegate {

    private final ApplicationDecisionService applicationDecisionService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("SaveDecisionProcess started");
        Map<String, Object> result = (Map<String, Object>) delegateExecution.getVariable("resultVariables");
        var responseDto = ApplicationDecisionDto.builder()
                .result((boolean) result.get("result"))
                .inn((String) delegateExecution.getVariable("inn"))
                .innDescription((String) result.get("innDecision"))
                .regionDescription((String) result.get("regionDecision"))
                .capitalDescription((String) result.get("capitalDecision"))
                .build();

        applicationDecisionService.saveApplicationDecision(responseDto);
    }
}
