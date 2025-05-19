package com.henrique.user_service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.henrique.user_service.controllers.dtos.UsuarioDTO;
import com.henrique.user_service.model.Usuario;
import com.henrique.user_service.model.UsuarioRepository;
import com.henrique.user_service.testdata.UsuarioTestDataProvider;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;


    @Test
    void inserirUsuarioComCamposValidos() {
        UsuarioDTO usuarioDTO = new UsuarioDTO("joao", "123");
        Usuario usuarioSalvo = new Usuario(1L, "joao", "123");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

        Usuario resposta = usuarioService.inserirUsuario(usuarioDTO);

        verify(usuarioRepository).save(any(Usuario.class));

        assertEquals(usuarioDTO.nome(), resposta.getNome());
        assertEquals(usuarioDTO.senha(), resposta.getSenha());
    }

    @ParameterizedTest
    @MethodSource("com.henrique.user_service.testdata.UsuarioTestDataProvider#fornecerCamposUsuarioVazio")
    void deveLancarExcecaoQuandoCamposUsuarioEstiveremVazios(String nome, String senha, String mensagemEsperada) {

        // Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, senha);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.inserirUsuario(usuarioDTO);
        });

        assertEquals(mensagemEsperada, exception.getMessage());
    }


}