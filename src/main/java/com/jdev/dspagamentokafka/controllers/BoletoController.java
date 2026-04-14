package com.jdev.dspagamentokafka.controllers;

import com.jdev.dspagamentokafka.entity.Boleto;
import com.jdev.dspagamentokafka.services.BoletoService;
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
public class BoletoController {

    @Autowired
    private BoletoService service;

    @PostMapping
    public ResponseEntity<Boleto> salvar(@RequestBody Boleto boleto){
        boleto = service.salvar(boleto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(boleto.getId()).toUri();

        return ResponseEntity.created(uri).body(boleto);
    }
}
