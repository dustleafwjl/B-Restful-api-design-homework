package com.thoughtworks.capability.gtb.restfulapidesign.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GroupControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_create_groups_success_when_post() throws Exception{
        mockMvc.perform(post("/groups"))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_get_groups_success_when_get() throws Exception{
        mockMvc.perform(post("/groups"))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/groups"))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_update_group_when_patch_given_id_and_group_name() throws Exception{
        mockMvc.perform(post("/groups"))
                .andExpect(status().isCreated());
        mockMvc.perform(patch("/groups/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"test1\"}"))
                .andExpect(jsonPath("$.name", is("test1")))
                .andExpect(status().isOk());
    }

    @Test
    public void should_bad_request_when_patch_given_wrong_id_and_group_name() throws Exception{
        mockMvc.perform(post("/groups"))
                .andExpect(status().isCreated());
        mockMvc.perform(patch("/groups/8")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"test1\"}"))
                .andExpect(jsonPath("$.detail.name", is("test")))
                .andExpect(status().isBadRequest());
    }
}