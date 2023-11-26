package com.application.vocealuga.service.impl;

import com.application.vocealuga.dto.FuncionarioDto;
import com.application.vocealuga.entity.ClienteEntity;
import com.application.vocealuga.entity.Funcionario;
import com.application.vocealuga.repository.ClienteRepository;
import com.application.vocealuga.repository.FuncionarioRepository;
import com.application.vocealuga.service.FuncionarioService;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private ClienteRepository clienteRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository, ClienteRepository clienteRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        return null;
    }

    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setDocumento(funcionarioDto.getDocumento());
        funcionario.setCargo(funcionarioDto.getCargo());

        String password = getGeneratedPassword(funcionarioDto.getDocumento());
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(funcionarioDto.getNome());
        cliente.setCpf(funcionarioDto.getDocumento());
        cliente.setSenha(password);

        try {
            clienteRepository.save(cliente);
            funcionario.setCliente(cliente);
            funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        FuncionarioDto funcionarioResponse = new FuncionarioDto();
        funcionarioResponse.setNome(funcionario.getNome());
        funcionarioResponse.setDocumento(funcionario.getDocumento());
        funcionarioResponse.setCargo(funcionario.getCargo());
        return funcionarioResponse;
    }

    private static String getGeneratedPassword(String documentField) throws Exception {
        String password;
        if (documentField.length() == 11) {
            password = documentField.substring(0, 3);
        } else if (documentField.length() == 14) {
            password = documentField.substring(0, 4);
        } else {
            throw new Exception("Documento inválido");
        }

        return password;
    }
}
