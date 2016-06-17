/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.service;

import com.richard.api.ws.model.Cliente;
import com.richard.api.ws.repository.ClienteRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author richard
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void excluir(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Cliente buscaPorId(Long id) {
        return clienteRepository.findOne(id);
    }

    public Cliente alterar(Cliente cliente) {
         return clienteRepository.save(cliente);
    }

}
