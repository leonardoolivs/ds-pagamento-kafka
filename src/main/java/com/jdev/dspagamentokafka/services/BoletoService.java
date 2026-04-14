package com.jdev.dspagamentokafka.services;

import com.jdev.dspagamentokafka.entity.Boleto;
import com.jdev.dspagamentokafka.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;

    public Boleto salvar(Boleto boleto){
        if(repository.existsByCodigoBarras(boleto.getCodigoBarras())){
            throw new RuntimeException("Código de Barras já usado");
        }

        return repository.save(boleto);
    }
}
