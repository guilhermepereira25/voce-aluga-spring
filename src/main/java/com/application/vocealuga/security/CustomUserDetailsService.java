package com.application.vocealuga.security;


import com.application.vocealuga.entity.ClienteEntity;
import com.application.vocealuga.repository.ClienteRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private ClienteRepository clienteRepository;

    public CustomUserDetailsService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String document) throws UsernameNotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findByCpf(document);

        if (clienteEntity == null) {
            clienteEntity = clienteRepository.findByCnpj(document);

            if (clienteEntity == null) {
                throw new UsernameNotFoundException("Cliente não encontrado");
            }
        }

        String username = String.format(clienteEntity.getNome()).toLowerCase();

        return new User(
                username,
                clienteEntity.getSenha(),
                clienteEntity.getPermissao().stream().map((role) -> new SimpleGrantedAuthority(role.getNome()))
                        .collect(Collectors.toList())
        );
    }
}
