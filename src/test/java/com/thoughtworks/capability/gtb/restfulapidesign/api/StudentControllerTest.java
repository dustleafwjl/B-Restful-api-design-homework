package com.thoughtworks.capability.gtb.restfulapidesign.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_created_when_create_student() throws Exception {
        String jsonStudent = "\"name\": \"Tom\", \"gender\": \"male\", \"note\": \"test student\"";
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStudent))
                .andExpect(status().isCreated());
    }
}