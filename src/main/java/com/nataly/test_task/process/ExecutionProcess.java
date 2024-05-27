package com.nataly.test_task.process;

import com.nataly.test_task.dto.ApplicationDecisionDto;
import com.nataly.test_task.dto.ApplicationDto;

public interface ExecutionProcess {

    ApplicationDecisionDto execute(ApplicationDto applicationDto);
}
