package com.application.vocealuga.controller;

import com.application.vocealuga.dto.MotoristaDto;
import com.application.vocealuga.entity.ClienteEntity;
import com.application.vocealuga.entity.Motorista;
import com.application.vocealuga.repository.ClienteRepository;
import com.application.vocealuga.repository.MotoristaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class MotoristaController {
    private final MotoristaRepository motoristaRepository;
    private final ClienteRepository clienteRepository;

    public MotoristaController(MotoristaRepository motoristaRepository, ClienteRepository clienteRepository) {
        this.motoristaRepository = motoristaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/cadastroMotorista")
    public String cadastroMotorista(Model model) {
        model.addAttribute("motorista", new MotoristaDto());
        return "form-motorista";
    }

    @PostMapping("/cadastrarMotorista")
    public String cadastroMotorista(@ModelAttribute MotoristaDto motoristaDto) {
        Motorista motorista = motoristaRepository.findByCnh(motoristaDto.getCnh());

        if (motorista != null) {
            return "form-motorista?error";
        }

        Motorista newDriver = new Motorista();
        newDriver.setCnh(motoristaDto.getCnh());
        newDriver.setNome(motoristaDto.getNome());
        ClienteEntity cliente = clienteRepository.findByCpf(motoristaDto.getDocumento());
        newDriver.setCliente(cliente);

        try {
            motoristaRepository.save(newDriver);
            return "form-motorista?success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "form-motorista?error";
        }
    }
}
