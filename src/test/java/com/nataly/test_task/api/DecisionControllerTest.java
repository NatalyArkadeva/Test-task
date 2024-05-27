package com.nataly.test_task.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nataly.test_task.TestTaskApplication;
import com.nataly.test_task.dto.ApplicationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestTaskApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DecisionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getDecision() throws Exception {

        var applicationDto = ApplicationDto.builder()
                .inn("1010")
                .region(12)
                .capital(BigDecimal.valueOf(5000000))
                .build();

        this.mockMvc.perform(
                        post("/api/v1/decision")
                                .content(objectMapper.writeValueAsString(applicationDto))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(false))
                .andExpect(jsonPath("inn").value(applicationDto.inn()));
    }
}
