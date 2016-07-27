/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.controller;

import com.richard.api.ws.model.User;
import com.richard.api.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author richard
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> cadastrarUser(@RequestBody User user) {
        User userResult = userService.cadastrar(user);
    
        return new ResponseEntity<User>(userResult, HttpStatus.OK);
    }
    
}
