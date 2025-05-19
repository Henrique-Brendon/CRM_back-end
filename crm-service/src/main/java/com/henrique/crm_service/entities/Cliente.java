package com.henrique.crm_service.entities;

import java.time.Instant;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Instant dataNascimento;
    private String email;
    private String rg;
    private String cpf;

    @ManyToOne
    private Vendedor vendedor;

    @Embedded
    private CepInfo endereco;

    @ManyToOne
    private Proposta proposta;

    public Cliente() {}

    public Cliente(Long id, String nome, Instant dataNascimento, String email, String rg, String cpf, Vendedor vendedor,
            CepInfo endereco, Proposta proposta) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.vendedor = vendedor;
        this.endereco = endereco;
        this.proposta = proposta;
    }


}