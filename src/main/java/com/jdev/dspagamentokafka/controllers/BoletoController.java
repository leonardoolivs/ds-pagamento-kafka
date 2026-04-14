package com.jdev.dspagamentokafka.controllers;

import com.jdev.dspagamentokafka.dtos.BoletoDTO;
import com.jdev.dspagamentokafka.dtos.request.BoletoRequestDTO;
import com.jdev.dspagamentokafka.entity.Boleto;
import com.jdev.dspagamentokafka.services.BoletoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/boletos")
@Tag(name = "Boletos", description = "API de Pagamento de Boletos")
public class BoletoController {

    @Autowired
    private BoletoService service;

    @PostMapping
    public ResponseEntity<BoletoDTO> salvar(@RequestBody BoletoRequestDTO request){
        BoletoDTO response = service.salvar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
