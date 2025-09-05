package com.example.validadorsenha.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControladorSenhaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void senhaValida_retornarValidoTrue() throws Exception {
        String json = "{ \"senha\": \"AbTp9!fok\" }";

        mockMvc.perform(post("/api/v1/senha/validar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.valido").value(true));
    }

    @Test
    void senhaInvalida_retornaValidoFalseEerros() throws Exception {
        String json = "{ \"senha\": \"AbTp9!foo\" }";

        mockMvc.perform(post("/api/v1/senha/validar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.valido").value(false))
            .andExpect(jsonPath("$.erros").isArray());
    }
}
