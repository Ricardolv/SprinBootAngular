/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.service;

import com.richard.api.ws.model.User;
import com.richard.api.ws.repository.UserRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author richard
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Collection<User> buscarTodos() {
        return userRepository.findAll();
    }

    public void excluir(User user) {
        userRepository.delete(user);
    }

    public User buscaPorId(Long id) {
        return userRepository.findOne(id);
    }

    public User alterar(User user) {
         return userRepository.save(user);
    }
    
    public User userName(User user) {
        return userRepository.buscarPorName(user.getName());
    }

    public User cadastrar(User user) {
        return userRepository.save(user);
    }
    
    public User buscarPorNome(String nome) {
        return userRepository.buscarPorName(nome);
    }

}
