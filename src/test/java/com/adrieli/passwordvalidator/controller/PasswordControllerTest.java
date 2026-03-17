package com.adrieli.passwordvalidator.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class PasswordControllerTest {

    private static final String URL = "/api/v1/password/validate";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnTrueWhenPasswordIsValid() throws Exception {

        String request = """
        {
            "password": "AbTp9!fok"
        }
        """;

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsInvalid() throws Exception {

        String request = """
        {
            "password": "aa"
        }
        """;

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsEmpty() throws Exception {

        String request = """
        {
            "password": ""
        }
        """;

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)).andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenBodyIsInvalid() throws Exception {

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

}

