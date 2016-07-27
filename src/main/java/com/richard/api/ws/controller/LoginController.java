/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.controller;

import com.richard.api.ws.model.User;
import com.richard.api.ws.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author richard
 */
@RestController
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public LoginResponse autentication(@RequestBody User user) throws ServletException {
        
        if (user.getName() == null || user.getPassword() == null) {
            throw  new ServletException("Nome e senha obrigatórios");
        }

        User userAutenticado = userService.buscarPorNome(user.getName());
        
        if (userAutenticado == null) {
            throw  new ServletException("Usuário não encontrado");
        }
        
        if (!userAutenticado.getPassword().equals(user.getPassword())) {
            throw  new ServletException("Usuário ou senha inválida");
        }
        
        String token = Jwts.builder()
                .setSubject(userAutenticado.getName())
                .signWith(SignatureAlgorithm.HS512, "banana")
                .setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
                .compact();
        
        return new LoginResponse(token);
    }
    
    private class LoginResponse {
        
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
        
    } 
    
}
