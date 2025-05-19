package com.henrique.crm_service.controllers.dtos;

public record CepDTO(
    String cep,
    String estado,
    String cidade,
    String bairro,
    String endereco
) {
    
}