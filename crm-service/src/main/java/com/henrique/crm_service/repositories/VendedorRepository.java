package com.henrique.crm_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.crm_service.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
}
