package com.henrique.user_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.user_service.controllers.dtos.LoginDTO;
import com.henrique.user_service.controllers.dtos.UsuarioDTO;
import com.henrique.user_service.services.UsuarioService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "https://crm-front-end-p1la.onrender.com", allowCredentials = "true")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> inserirUsuario(@RequestBody UsuarioDTO entity) {
        log.info("Recebida requisição para inserir usuário: {}", entity.nome());

        usuarioService.inserirUsuario(entity);

        log.info("Usuário '{}' inserido com sucesso.", entity.nome());
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        log.info("Tentativa de login para o usuário: {}", loginDTO.nome());

        boolean autenticado = usuarioService.autenticar(loginDTO.nome(), loginDTO.senha());

        if (autenticado) {
            log.info("Login bem-sucedido para o usuário: {}", loginDTO.nome());
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            log.warn("Falha de autenticação para o usuário: {}", loginDTO.nome());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
    
}
