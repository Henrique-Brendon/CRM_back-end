package com.henrique.crm_service.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.crm_service.entities.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    
    Page<Proposta> findAll(Pageable pageable);
}
