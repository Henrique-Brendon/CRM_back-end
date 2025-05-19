package com.henrique.crm_service.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.crm_service.controllers.dtos.CepDTO;
import com.henrique.crm_service.services.CepService;
import com.henrique.crm_service.utils.CepUtil;

@RestController
@RequestMapping("/cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @Autowired
    private CepUtil cepUtil;

    @GetMapping("/localizarEndereco")
    public ResponseEntity<CepDTO> localizarEndereco(@RequestParam String cep) throws IOException, InterruptedException {
        CepDTO resposta = cepService.verificarEndereco(cepUtil.consultarCep(cep));
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
    
}