package com.api.api_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
    public void saveClienteTest(){
        
        Cliente cliente = clienteService.saveCliente(cliente);
        assertEquals("nome", cliente.nome);
        assertTrue(cliente.toString().contains("Cliente{"));
    }

    @Test
    public void getClienteByIdTest(){
        Cliente cliente = clienteService.getClienteById(1);
        assertEquals("1", cliente.id);
        assertEquals("rebeca", cliente.nome);
    }

    @Test
    public void deleteClienteTest(){
        clienteService.deleteCliente(1);
        Optional<Cliente> optionalCliente = clienteRepository.findById(1);
        assertTrue(!optionalCliente.isPresent());
    }

}

