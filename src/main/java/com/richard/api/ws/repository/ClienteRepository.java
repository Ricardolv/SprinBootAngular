/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.repository;

import com.richard.api.ws.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author richard
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
