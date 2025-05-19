package com.henrique.user_service.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.user_service.controllers.dtos.UsuarioDTO;
import com.henrique.user_service.services.UsuarioService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.stream.Stream;

import org.springframework.http.MediaType;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void salvarUsuario_ComDadosValidos_DeveRetornarStatusCreatedEConfirmacao() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO("Laura", "senha123");

        mockMvc.perform(post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioDTO)))
            .andExpect(status().isCreated())
            .andExpect(content().string("Usuario criado!"));
    }

    @ParameterizedTest
    @MethodSource("com.henrique.user_service.testdata.UsuarioTestDataProvider#fornecerCamposUsuarioVazio")
    void salvarUsuario_ComCamposInvalidos_DeveRetornarBadRequestComMensagemDeErro(
            String nome, String senha, String mensagemEsperada) throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, senha);

        // Configura o mock para lançar a exceção esperada
        doThrow(new IllegalArgumentException(mensagemEsperada))
            .when(usuarioService).inserirUsuario(any());

        mockMvc.perform(post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioDTO)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.error").value("Campo obrigatório"))
            .andExpect(jsonPath("$.message").value(mensagemEsperada))
            .andExpect(jsonPath("$.path").value("/usuario"));
    }

}