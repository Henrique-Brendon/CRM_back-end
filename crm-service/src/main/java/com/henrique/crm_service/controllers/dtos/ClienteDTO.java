package com.henrique.crm_service.controllers.dtos;

import com.henrique.crm_service.controllers.dtos.utils.FormatarData;
import com.henrique.crm_service.entities.CepInfo;
import com.henrique.crm_service.entities.Cliente;

public record ClienteDTO(
    String nome,
    String dataNascimento,
    String email,
    String rg,
    String cpf,
    String cep,
    String estado,
    String cidade,
    String bairro,
    String endereco,
    String numCasa
) {

    public static ClienteDTO fromClientes(Cliente cliente) {
        CepInfo cepInfo = cliente.getEndereco();

        return new ClienteDTO(
            cliente.getNome(),
            FormatarData.formatarData(cliente.getDataNascimento()),
            cliente.getEmail(),
            cliente.getRg(),
            cliente.getCpf(),
            cepInfo != null ? cepInfo.getCep() : null,
            cepInfo != null ? cepInfo.getEstado() : null,
            cepInfo != null ? cepInfo.getCidade() : null,
            cepInfo != null ? cepInfo.getBairro() : null,
            cepInfo != null ? cepInfo.getEndereco() : null,
            cepInfo != null ? cepInfo.getNumCasa() : null
        );
    }
}
