package com.jdev.dspagamentokafka.dtos.request;

import com.jdev.dspagamentokafka.entity.Boleto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoRequestDTO {

    private String codigoBarras;

    public Boleto toEntity() {
        Boleto boleto = new Boleto();

        boleto.setCodigoBarras(this.codigoBarras);

        return boleto;
    }
}
