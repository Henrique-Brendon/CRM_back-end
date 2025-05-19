package com.henrique.crm_service.entities;

import java.math.BigDecimal;
import java.time.Instant;

import com.henrique.crm_service.entities.enums.EstadoProposta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dataDeProposta;
    private BigDecimal valor;
    private String parcelas;
    private EstadoProposta estadoProposta;

    @OneToOne
    private Cliente cliente;
}
