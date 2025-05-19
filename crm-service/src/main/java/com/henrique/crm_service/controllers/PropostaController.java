package com.henrique.crm_service.controllers;   

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.crm_service.controllers.dtos.NovaPropostaDTO;
import com.henrique.crm_service.controllers.dtos.PropostaDTO;
import com.henrique.crm_service.services.PropostaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("proposta")
@CrossOrigin(origins = "https://crm-front-end-p1la.onrender.com", allowCredentials = "true")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @GetMapping("/paginas")
    public List<PropostaDTO> findAll(Pageable pageable) {
        return propostaService.findAll(pageable)
                            .map(PropostaDTO::fromProposta)
                            .getContent();
    }

    @PostMapping("/novaProposta/{vendedorId}")
    public ResponseEntity<?> novaProposta(
            @PathVariable Long vendedorId,
            @RequestBody NovaPropostaDTO dto) {

        propostaService.criarNovaProposta(vendedorId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

    /* 
    @GetMapping
    public Page<PropostaDTO> getPropostasPaginadas(Pageable pageable) {
        return (Page<PropostaDTO>) propostaService.getAllPropostas(pageable).getContent();
    }
    */
}
