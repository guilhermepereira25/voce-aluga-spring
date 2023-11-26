package com.application.vocealuga.controller;

import com.application.vocealuga.dto.DevolucaoDto;
import com.application.vocealuga.entity.Devolucao;
import com.application.vocealuga.entity.Motorista;
import com.application.vocealuga.repository.DevolucaoRepository;
import com.application.vocealuga.repository.MotoristaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class DevolucaoController {
    private MotoristaRepository motoristaRepository;
    private DevolucaoRepository devolucaoRepository;

    public DevolucaoController(MotoristaRepository motoristaRepository, DevolucaoRepository devolucaoRepository) {
        this.motoristaRepository = motoristaRepository;
        this.devolucaoRepository = devolucaoRepository;
    }

    @PostMapping("/devolver/veiculo")
    public String devolver(@ModelAttribute DevolucaoDto devolucaoDto, Model model) {
        Motorista motorista = motoristaRepository.findByCnh(devolucaoDto.getCnh());
        if (motorista == null) {
            return "redirect:/veiculo/devolver?error=1";
        }

        Devolucao devolucao = new Devolucao();
        devolucao.setCobranca(devolucaoDto.getCobranca());
        devolucao.setDescricao(devolucaoDto.getDescricao());
        devolucao.setMotorista(motorista);

        try {
            devolucaoRepository.save(devolucao);
            return "redirect:/veiculo/devolver?success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/veiculo/devolver?error=1";
        }
    }
}
