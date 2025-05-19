package com.henrique.user_service.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.henrique.user_service.model.Usuario;
import com.henrique.user_service.model.UsuarioRepository;

@Configuration
@Component
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "joao", "123456");
        Usuario u2 = new Usuario(null, "maria", "654321");
        Usuario u3 = new Usuario(null, "ana", "senha123");

        usuarioRepository.saveAll(List.of(u1, u2, u3));

        System.out.println("Usuários inseridos com sucesso!");
    }
}
