package com.nataly.test_task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public record ApplicationDto(
        @NotBlank
        String inn,
        @NotNull
        Integer region,
        @NotNull
        BigDecimal capital
) {
}
