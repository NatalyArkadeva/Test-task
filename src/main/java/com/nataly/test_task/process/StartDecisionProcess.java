package com.nataly.test_task.process;

import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class StartDecisionProcess {

    private final ApplicationService service;

    public void startProcess(ApplicationDto request) {
        service.saveApplication(request);
        Map<String, Object> variables = new HashMap<>();
        variables.put("inn", request.inn());
        variables.put("region", request.region());
        variables.put("capital", request.capital());

        ProcessEngines.getDefaultProcessEngine()
                .getRuntimeService()
                .startProcessInstanceByKey("process", variables);
        log.info("StartDecisionProcess started");
    }
}
