package com.application.vocealuga.controller;

import com.application.vocealuga.dto.VeiculoDto;
import com.application.vocealuga.entity.Veiculo;
import com.application.vocealuga.service.impl.AgenciaServiceImpl;
import com.application.vocealuga.service.impl.VeiculoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class VeiculoController {
    private VeiculoServiceImpl veiculoService;
    private AgenciaServiceImpl agenciaService;

    public VeiculoController(VeiculoServiceImpl veiculoService, AgenciaServiceImpl agenciaService) {
        this.veiculoService = veiculoService;
        this.agenciaService = agenciaService;
    }

    @GetMapping("/catalogoVeiculos")
    public String catalogoVeiculos(Model model) {
        model.addAttribute("veiculos", veiculoService.findBySituacao("ativo"));
        return "catalogo-veiculos";
    }

    @GetMapping("/cadastroVeiculo")
    String veiculo(Model model) {
        model.addAttribute("agencias", agenciaService.findAll());
        model.addAttribute("veiculo", new VeiculoDto());
        return "form-veiculo";
    }

    @PostMapping("/cadastrarVeiculo")
    public String createVeiculo(@ModelAttribute VeiculoDto veiculoDto) {
        Boolean veiculoExists = veiculoService.existsByPlaca(veiculoDto.getPlaca());
        if (veiculoExists) {
            return "redirect:/cadastroVeiculo?error=1";
        }

        Boolean veiculoSaved = veiculoService.saveVeiculo(veiculoDto);
        if (!veiculoSaved) {
            return "redirect:/cadastroVeiculo?error=2";
        }

        return "redirect:/cadastroVeiculo?success";
    }

    @GetMapping("/veiculo/alugar/{id}")
    public String alugarVeiculo(@PathVariable("id") Long id, Model model) {
        Veiculo veiculo = veiculoService.findById(id);

        if (veiculo == null) {
            return "redirect:/catalogoVeiculos";
        }

        model.addAttribute("veiculo", veiculo);
        return "reserva";
    }
}
