package com.nataly.test_task.api;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.dto.ApplicationDto;
import com.nataly.test_task.process.ExecutionProcess;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DecisionController {

    private final ExecutionProcess executionProcess;

    @Operation(summary = "Получение решения по заявке")
    @PostMapping("/decision")
    public ResponseEntity<ApplicationDecisionDto> getDecision(@RequestBody @Valid ApplicationDto request) {
        var responseDto = executionProcess.execute(request);
        return ResponseEntity.ok(responseDto);
    }
}
