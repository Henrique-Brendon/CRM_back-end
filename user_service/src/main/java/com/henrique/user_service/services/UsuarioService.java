package com.henrique.user_service.services;

import org.springframework.stereotype.Service;

import com.henrique.user_service.controllers.dtos.UsuarioDTO;
import com.henrique.user_service.model.Usuario;
import com.henrique.user_service.model.UsuarioRepository;
import com.henrique.user_service.services.exceptions.UsuarioServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {
  
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean autenticar(String nome, String senha) {
        log.debug("Autenticando usuário: {}", nome);
        boolean encontrado = usuarioRepository.findByNomeAndSenha(nome, senha).isPresent();

        if (encontrado) {
            log.debug("Usuário '{}' autenticado com sucesso.", nome);
        } else {
            log.debug("Usuário '{}' não encontrado ou senha inválida.", nome);
        }

        return encontrado;
    }

    public Usuario inserirUsuario(UsuarioDTO usuarioDTO) {
        log.debug("Iniciando inserção do usuário: {}", usuarioDTO.nome());

        try {
            validarUsuarioDTO(usuarioDTO);
            Usuario usuario = new Usuario(null, usuarioDTO.nome(), usuarioDTO.senha());
            Usuario salvo = usuarioRepository.save(usuario);

            log.info("Usuário '{}' salvo com ID: {}", salvo.getNome(), salvo.getId());
            return salvo;
        } catch (Exception ex) {
            log.error("Erro ao inserir usuário '{}': {}", usuarioDTO.nome(), ex.getMessage());
            throw new UsuarioServiceException("Erro ao inserir o usuário");
        }
    }

    private void validarUsuarioDTO(UsuarioDTO dto) {
        if (dto == null) {
            log.warn("Validação falhou: DTO do usuário é nulo");
            throw new NullPointerException("Usuário não pode ser nulo.");
        }
        if (dto.nome() == null || dto.nome().trim().isEmpty()) {
            log.warn("Validação falhou: nome vazio ou nulo");
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio ou nulo.");
        }
        if (dto.senha() == null || dto.senha().trim().isEmpty()) {
            log.warn("Validação falhou: senha vazia ou nula");
            throw new IllegalArgumentException("Senha do usuário não pode ser vazia ou nula.");
        }
    }
}
