package com.henrique.user_service.services.exceptions;

public class UsuarioServiceException extends RuntimeException {
    public UsuarioServiceException(String info) {
        super(info);
    }
}
