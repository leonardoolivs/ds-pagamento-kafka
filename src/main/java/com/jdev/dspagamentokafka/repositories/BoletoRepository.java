package com.jdev.dspagamentokafka.repositories;

import com.jdev.dspagamentokafka.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
    boolean existsByCodigoBarras(String codigoBarras);
}
