package com.henrique.crm_service.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.henrique.crm_service.controllers.dtos.NovaPropostaDTO;
import com.henrique.crm_service.controllers.dtos.PropostaDTO;
import com.henrique.crm_service.controllers.dtos.utils.FormatarData;
import com.henrique.crm_service.entities.CepInfo;
import com.henrique.crm_service.entities.Cliente;
import com.henrique.crm_service.entities.Proposta;
import com.henrique.crm_service.entities.Vendedor;
import com.henrique.crm_service.entities.enums.EstadoProposta;
import com.henrique.crm_service.repositories.ClienteRepository;
import com.henrique.crm_service.repositories.PropostaRepository;
import com.henrique.crm_service.repositories.VendedorRepository;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final ClienteRepository clienteRepository;
    private final VendedorRepository vendedorRepository;

    public PropostaService(
            PropostaRepository propostaRepository,
            ClienteRepository clienteRepository,
            VendedorRepository vendedorRepository) {
        this.propostaRepository = propostaRepository;
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
    }
    public Page<Proposta> findAll(Pageable pageable) {
        return propostaRepository.findAll(pageable);
    }

    public Page<PropostaDTO> getAllPropostas(Pageable pageable) {
        return propostaRepository.findAll(pageable)
                .map(PropostaDTO::fromProposta);
    }

    public void criarNovaProposta(Long vendedorId, NovaPropostaDTO dto) {
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
            .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));

        // Cria o endereço do cliente
        CepInfo endereco = new CepInfo(
            dto.cepCliente(),
            dto.estadoCliente(),
            dto.cidadeCliente(),
            dto.bairroCliente(),
            dto.enderecoCliente(),
            dto.numCasaCliente()
        );

        Cliente cliente = new Cliente(
            null,
            dto.nomeCliente(),
            FormatarData.converterParaInstant(dto.dataNascimentoCliente()),
            dto.emailCliente(),
            dto.rgCliente(),
            dto.cpfCliente(),
            vendedor,
            endereco, null
        );
        clienteRepository.save(cliente); // salva cliente sem proposta

        Proposta proposta = new Proposta(
            null,
            FormatarData.converterParaInstant(dto.dataDeProposta()),
            new BigDecimal(dto.valor()), dto.parcelas(),
            EstadoProposta.valueOf(dto.estadoProposta()),
            cliente
        );

        propostaRepository.save(proposta);

        // associa a proposta ao cliente e salva de novo
        cliente.setProposta(proposta);
        clienteRepository.save(cliente);

    }

}
