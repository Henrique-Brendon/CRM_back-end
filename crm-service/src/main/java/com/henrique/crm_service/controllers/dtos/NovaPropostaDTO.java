package com.henrique.crm_service.controllers.dtos;


public record NovaPropostaDTO(
    // CLIENTE
    String nomeCliente,
    String dataNascimentoCliente,
    String emailCliente,
    String rgCliente,
    String cpfCliente,
    String cepCliente,
    String estadoCliente,
    String cidadeCliente,
    String bairroCliente,
    String enderecoCliente,
    String numCasaCliente,
    // PROPOSTA
    String dataDeProposta,
    String valor,
    String parcelas,
    String estadoProposta
) {
    
}
