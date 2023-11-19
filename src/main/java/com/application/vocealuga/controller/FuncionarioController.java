package com.application.vocealuga.controller;

import com.application.vocealuga.dto.FuncionarioDto;
import com.application.vocealuga.entity.Funcionario;
import com.application.vocealuga.repository.FuncionarioRepository;
import com.application.vocealuga.service.ClienteService;
import com.application.vocealuga.service.impl.ClienteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class FuncionarioController {
    private FuncionarioRepository funcionarioRepository;
    private ClienteServiceImpl clienteService;

    public FuncionarioController(FuncionarioRepository funcionarioRepository, ClienteServiceImpl clienteService) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteService = clienteService;
    }

    @GetMapping("/cadastroFuncionario")
    public String functionario(Model model) {
        model.addAttribute("funcionario", new FuncionarioDto());
        return "cadastrar-funcionario";
    }

    @PostMapping("/cadastrarFuncionar")
    public void cadastrarFuncionario(@ModelAttribute FuncionarioDto funcionarioDto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setDocumento(funcionarioDto.getDocumento());
        funcionario.setCargo(funcionarioDto.getCargo());


        funcionarioRepository.save(funcionario);
    }
}
