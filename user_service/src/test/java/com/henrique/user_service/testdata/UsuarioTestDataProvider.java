package com.henrique.user_service.testdata;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class UsuarioTestDataProvider {
    
        public static Stream<Arguments> fornecerCamposUsuarioVazio() {
        return Stream.of(
            Arguments.of("", "senha123", "Nome do usuário não pode ser vazio ou nulo."),
            Arguments.of("João", "", "Senha do usuário não pode ser vazia ou nula.")
        );
    }
}
