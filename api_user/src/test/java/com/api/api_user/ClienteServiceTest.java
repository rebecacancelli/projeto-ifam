package com.api.api_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.api.api_user.domain.dto.ClienteDto;
import com.api.api_user.domain.entity.Cliente;
import com.api.api_user.domain.repository.ClienteRepository;
import com.api.api_user.domain.service.ClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class ClienteServiceTest {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void getClienteByIdTest() {
        long object_index = Long.valueOf(1);
        ClienteDto cliente = clienteService.getClienteById(object_index);
        assertNotEquals(cliente, null);
    }

    @Test
    public void updateClienteTest() {
        long object_index = Long.valueOf(1);
        ClienteDto cliente = clienteService.getClienteById(object_index);
        assertEquals("rebeca", cliente.getNome());
    }
    @Test
    public void deleteClienteTest() {
        long object_index = Long.valueOf(1);
        clienteService.deleteCliente(object_index);
        Optional<Cliente> optionalCliente = clienteRepository.findById(object_index);
        assertTrue(!optionalCliente.isPresent());
    }
}

