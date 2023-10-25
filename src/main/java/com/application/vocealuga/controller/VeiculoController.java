package com.application.vocealuga.controller;

import com.application.vocealuga.dto.VeiculoDto;
import com.application.vocealuga.service.impl.AgenciaServiceImpl;
import com.application.vocealuga.service.impl.VeiculoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/veiculo")
    String veiculo(Model model) {
        model.addAttribute("agencias", agenciaService.findAll());
        model.addAttribute("veiculo", new VeiculoDto());
        return "veiculo";
    }

    @PostMapping("/veiculo")
    public String createVeiculo(@ModelAttribute VeiculoDto veiculoDto) {
        Boolean veiculoExists = veiculoService.existsByPlaca(veiculoDto.getPlaca());
        if (veiculoExists) {
            return "redirect:/veiculo?error=1";
        }

        Boolean veiculoSaved = veiculoService.saveVeiculo(veiculoDto);
        if (!veiculoSaved) {
            return "redirect:/veiculo?error=2";
        }

        return "redirect:/veiculo?success";
    }
}
