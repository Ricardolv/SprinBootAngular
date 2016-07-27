/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.api.ws.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author richard
 */
public class TokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        
        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader("Authorization");
        
        if (header == null || !header.startsWith("Bearer ")) {
            throw new ServletException("Token inexistente ou inválido");
        }
        
        String token = header.substring(7);
        
        try {
            Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
            
        } catch (SignatureException e) {
            throw new ServletException("Token inválido");
        }
        
        
        filterChain.doFilter(request, response);

    }
    
}
