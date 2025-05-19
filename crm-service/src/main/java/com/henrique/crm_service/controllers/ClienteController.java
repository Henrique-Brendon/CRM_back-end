package com.henrique.crm_service.controllers;   

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.crm_service.controllers.dtos.ClienteDTO;
import com.henrique.crm_service.services.ClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin(origins = "https://crm-front-end-p1la.onrender.com", allowCredentials = "true")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/paginas")
    public List<ClienteDTO> findAll(Pageable pageable) {
        return clienteService.findAll(pageable)
                            .map(ClienteDTO::fromClientes)
                            .getContent();
    }

}
