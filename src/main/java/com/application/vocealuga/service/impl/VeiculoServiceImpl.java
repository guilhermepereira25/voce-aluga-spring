package com.application.vocealuga.service.impl;

import com.application.vocealuga.dto.VeiculoDto;
import com.application.vocealuga.entity.Agencia;
import com.application.vocealuga.entity.Veiculo;
import com.application.vocealuga.repository.AgenciaRepository;
import com.application.vocealuga.repository.VeiculoRepository;
import com.application.vocealuga.service.VeiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    private VeiculoRepository veiculoRepository;
    private AgenciaRepository agenciaRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, AgenciaRepository agenciaRepository) {
        this.veiculoRepository = veiculoRepository;
        this.agenciaRepository = agenciaRepository;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Boolean saveVeiculo(VeiculoDto veiculoDto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(veiculoDto.getPlaca());
        veiculo.setModelo(veiculoDto.getModelo());
        veiculo.setKm(veiculoDto.getKm());
        veiculo.setStatus(veiculoDto.getStatus());
        veiculo.setDescricao(veiculoDto.getDescricao());
        veiculo.setAno(veiculoDto.getAno());
        Agencia agencia = agenciaRepository.findById(veiculoDto.getAgenciaId()).orElse(null);
        veiculo.setAgencia(agencia);

        try {
            veiculoRepository.save(veiculo);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean existsByPlaca(String placa) {
        return veiculoRepository.existsByPlaca(placa);
    }
}
