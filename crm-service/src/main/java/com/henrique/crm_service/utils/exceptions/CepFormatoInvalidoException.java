package com.henrique.crm_service.utils.exceptions;

public class CepFormatoInvalidoException extends RuntimeException {
    public CepFormatoInvalidoException(String cep) {
        super("Formato de CEP inválido: " + cep);
    }
}