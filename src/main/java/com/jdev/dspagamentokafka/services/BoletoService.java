package com.jdev.dspagamentokafka.services;

import com.jdev.dspagamentokafka.dtos.BoletoDTO;
import com.jdev.dspagamentokafka.entity.Boleto;
import com.jdev.dspagamentokafka.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;

    @Transactional
    public BoletoDTO salvar(BoletoDTO dto){
        if(repository.existsByCodigoBarras(dto.getCodigoBarras())){
            throw new RuntimeException("Código de Barras já usado");
        }

        Boleto boleto = dto.toEntity();

        repository.save(boleto);

        return BoletoDTO.fromEntity(boleto);
    }
}
