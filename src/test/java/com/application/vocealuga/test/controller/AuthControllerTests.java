package com.application.vocealuga.test.controller;

import com.application.vocealuga.controller.AuthController;
import com.application.vocealuga.repository.PermissaoRepository;
import com.application.vocealuga.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AuthController.class)
public class AuthControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PermissaoRepository permissaoRepository;
    @MockBean
    private ClienteServiceImpl clienteService;


    @Test
    public void shouldReturnLoginPageWithSuccess() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnCadastroPageWithSuccess() throws Exception {
        this.mockMvc.perform(get("/cadastro"))
                .andExpect(status().isOk());
    }
}
