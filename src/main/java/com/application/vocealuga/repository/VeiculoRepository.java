package com.application.vocealuga.repository;

import com.application.vocealuga.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Veiculo findByPlaca(String placa);

    Boolean existsByPlaca(String placa);
}
