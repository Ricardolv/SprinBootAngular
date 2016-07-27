/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.repository;

import com.richard.api.ws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author richard
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> { 
        
        @Query(value = "select u from User u where u.name=:uname")
        public User buscarPorName(@Param("uname")String name);
        
}
