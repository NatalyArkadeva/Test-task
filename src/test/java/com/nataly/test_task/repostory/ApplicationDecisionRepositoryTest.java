package com.nataly.test_task.repostory;

import com.nataly.test_task.TestTaskApplication;
import com.nataly.test_task.model.ApplicationDecisionEntity;
import com.nataly.test_task.model.ApplicationEntity;
import com.nataly.test_task.repositry.ApplicationDecisionRepository;
import com.nataly.test_task.repositry.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestTaskApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationDecisionRepositoryTest {

    @Autowired
    private ApplicationDecisionRepository applicationDecisionRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    void findByApplicationInn() {
        var application = ApplicationEntity.builder()
                .id(1L)
                .inn("1012101210")
                .capital(BigDecimal.ONE)
                .region(12)
                .build();
        applicationRepository.save(application);

        var decision = ApplicationDecisionEntity.builder()
                .id(1L)
                .result(true)
                .application(application)
                .capitalDescription("description")
                .build();
        applicationDecisionRepository.save(decision);

        var result = applicationDecisionRepository.findByApplicationInn(application.getInn());

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).usingRecursiveComparison().ignoringFields("id")
                .isEqualTo(decision);
    }
}
