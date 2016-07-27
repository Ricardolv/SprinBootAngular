package com.richard.api;

import com.richard.api.ws.controller.TokenFilter;
import com.richard.api.ws.model.Cliente;
import com.richard.api.ws.repository.ClienteRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiWebApplication {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }
    
    @Bean
    public FilterRegistrationBean filterJwt() {
        FilterRegistrationBean  frb = new FilterRegistrationBean();
        
        frb.setFilter(new TokenFilter());
        frb.addUrlPatterns("/admin/*");
        
        return frb;
    }
    
    @Bean(name = "createClientes")
    public CommandLineRunner createClientes(ClienteRepository clienteRepository) {
        return (args) -> {
            // save a couple of users
            clienteRepository.save(new Cliente("Richard", "11122233344"));
            clienteRepository.save(new Cliente("Chloe", "22233344455"));
            clienteRepository.save(new Cliente("Kim", "33344455566"));
            clienteRepository.save(new Cliente("David", "44455566677"));
            clienteRepository.save(new Cliente("Michelle", "66677788899"));

            // fetch all customers
            log.info("Clients found with findAll():");
            log.info("-------------------------------");
            for (Cliente cliente : clienteRepository.findAll()) {
                log.info(cliente.toString());
            }

            log.info("");
        };
    }
}
