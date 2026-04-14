package com.jdev.dspagamentokafka.dtos;

import com.jdev.dspagamentokafka.entity.Boleto;
import com.jdev.dspagamentokafka.enums.Situacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoDTO {

    private Long id;
    private String codigoBarras;
    private Situacao situacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public static BoletoDTO fromEntity(Boleto entity) {
        return new BoletoDTO(
                entity.getId(),
                entity.getCodigoBarras(),
                entity.getSituacao(),
                entity.getDataCriacao(),
                entity.getDataAtualizacao()
        );
    }
}
