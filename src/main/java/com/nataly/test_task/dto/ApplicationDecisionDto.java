package com.nataly.test_task.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record ApplicationDecisionDto(
        boolean result,
        String inn,
        String innDescription,
        String regionDescription,
        String capitalDescription
) {
}
