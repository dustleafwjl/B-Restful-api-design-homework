package com.thoughtworks.capability.gtb.restfulapidesign.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Test
    public void should_return_204_when_delete_student_given_id() throws Exception {
        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void should_get_students_when_get_all_students() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());

    }

    @Test
    public void should_get_male_students_when_get_students_by_gender_given_male() throws Exception {
        mockMvc.perform(get("/students/female"))
                .andExpect(status().isOk());
    }
}