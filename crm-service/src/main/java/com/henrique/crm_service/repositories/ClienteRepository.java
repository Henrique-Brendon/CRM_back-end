package com.henrique.crm_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.crm_service.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
