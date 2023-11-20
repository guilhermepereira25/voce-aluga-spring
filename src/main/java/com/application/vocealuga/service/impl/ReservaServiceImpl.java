package com.application.vocealuga.service.impl;

import com.application.vocealuga.dto.ReservaDto;
import com.application.vocealuga.entity.ClienteEntity;
import com.application.vocealuga.entity.Funcionario;
import com.application.vocealuga.entity.Motorista;
import com.application.vocealuga.repository.ClienteRepository;
import com.application.vocealuga.repository.FuncionarioRepository;
import com.application.vocealuga.repository.MotoristaRepository;
import com.application.vocealuga.repository.TransactionRepository;
import com.application.vocealuga.service.ReservaService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {
    private ClienteRepository clienteRepository;
    private MotoristaRepository motoristaRepository;
    private FuncionarioRepository funcionarioRepository;

    public ReservaServiceImpl(ClienteRepository clienteRepository, MotoristaRepository motoristaRepository, FuncionarioRepository funcionarioRepository) {
        this.clienteRepository = clienteRepository;
        this.motoristaRepository = motoristaRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void saveReserva(ReservaDto reservaDto) {
        String document = reservaDto.getClienteDocument();
        ClienteEntity cliente;
        if (document.length() == 11) {
            cliente = clienteRepository.findByCpf(document);
        } else {
            cliente = clienteRepository.findByCnpj(document);
        }

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        String cnhCondutor = reservaDto.getCnhCondutor();
        Motorista motorista = motoristaRepository.findByCnh(cnhCondutor);
        if (motorista == null) {
            throw new RuntimeException("Motorista não encontrado");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Funcionario funcionario = funcionarioRepository.findByDocumento(username);
        if (funcionario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }


        return;
    }

    public void deleteReserva() {
        return;
    }

    public void updateReserva() {
        return;
    }
}
