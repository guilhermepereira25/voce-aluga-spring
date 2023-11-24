package com.application.vocealuga.controller;

import com.application.vocealuga.dto.ClienteDto;
import com.application.vocealuga.entity.ClienteEntity;
import com.application.vocealuga.service.impl.ClienteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class ClienteController {
    private ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/consultarCliente")
    String consultarCliente(@ModelAttribute("clienteDto") ClienteDto clienteDto, Model model) {
            if (clienteDto != null) {
                String document = clienteDto.getDocument();
                ClienteEntity cliente;
                if (document.length() == 11) {
                    cliente = clienteService.findByCpf(document);
                } else if (document.length() == 14) {
                    cliente = clienteService.findByCnpj(document);
                } else {
                    return "redirect:/consultarCliente?error=1";
                }

                model.addAttribute("cliente", cliente);
            } else {
                model.addAttribute("cliente", null);
            }

            model.addAttribute("clienteDto", new ClienteDto());
            return "consultarCliente";
    }
}
