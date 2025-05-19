package com.henrique.crm_service.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.crm_service.entities.Proposta;
import com.henrique.crm_service.repositories.ClienteRepository;
import com.henrique.crm_service.repositories.PropostaRepository;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "https://crm-front-end-p1la.onrender.com", allowCredentials = "true")
public class DashboardController {

    private final PropostaRepository propostaRepository;
    private final ClienteRepository clienteRepository;

    public DashboardController(PropostaRepository propostaRepository, ClienteRepository clienteRepository) {
        this.propostaRepository = propostaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/propostas/por-faixa-valor")
    public Map<String, Long> getPropostasPorFaixaValor() {
        return propostaRepository.findAll().stream()
            .collect(Collectors.groupingBy(p -> {
                BigDecimal valor = p.getValor();
                if (valor.compareTo(new BigDecimal("1000")) <= 0) return "Até R$1.000";
                else if (valor.compareTo(new BigDecimal("3000")) <= 0) return "R$1.001 - R$3.000";
                else if (valor.compareTo(new BigDecimal("5000")) <= 0) return "R$3.001 - R$5.000";
                else return "Acima de R$5.000";
            }, Collectors.counting()));
    }


    @GetMapping("/ranking-vendedores")
    public List<Map<String, Object>> getRankingVendedores() {
        return propostaRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                p -> p.getCliente().getVendedor().getNome(),
                Collectors.mapping(Proposta::getValor, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            ))
            .entrySet().stream()
            .map(e -> {
                Map<String, Object> map = new HashMap<>();
                map.put("nome", e.getKey());
                map.put("totalVendido", e.getValue());
                return map;
            })
            .sorted((m1, m2) -> ((BigDecimal) m2.get("totalVendido")).compareTo((BigDecimal) m1.get("totalVendido")))
            .collect(Collectors.toList());
    }


    @GetMapping("/propostas/por-estado")
    public Map<String, Long> getPropostasPorEstado() {
        return propostaRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                p -> p.getCliente().getEndereco().getEstado(),
                Collectors.counting()
            ));
    }

    @GetMapping("/propostas/por-vendedor")
    public Map<String, Long> getPropostasPorVendedor() {
        return propostaRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                p -> p.getCliente().getVendedor().getNome(),
                Collectors.counting()
            ));
    }

    @GetMapping("/valores/media-por-estado")
    public Map<String, Double> getMediaValorPropostaPorEstado() {
        return propostaRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                p -> p.getCliente().getEndereco().getEstado(),
                Collectors.averagingDouble(p -> p.getValor().doubleValue())
            ));
    }

    @GetMapping("/clientes/por-estado")
    public Map<String, Long> getClientesPorEstado() {
        return clienteRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                c -> c.getEndereco().getEstado(),
                Collectors.counting()
            ));
    }
}
