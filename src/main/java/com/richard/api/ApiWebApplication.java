package com.richard.api;

import com.richard.api.ws.model.Cliente;
import com.richard.api.ws.repository.ClienteRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EntityScan(basePackages = "com.richard.api.ws.model")
//@EnableJpaRepositories(basePackages = {"com.richard.api.ws.repository"})
//@ComponentScan(basePackages = {"com.richard.api.ws.controller"})
public class ApiWebApplication {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }

    @Bean(name = "createClientes")
    public CommandLineRunner createUsuarios(ClienteRepository clienteRepository) {
        return (args) -> {
            // save a couple of users
            clienteRepository.save(new Cliente("Richard", "11122233344"));
            clienteRepository.save(new Cliente("Chloe", "22233344455"));
            clienteRepository.save(new Cliente("Kim", "33344455566"));
            clienteRepository.save(new Cliente("David", "44455566677"));
            clienteRepository.save(new Cliente("Michelle", "66677788899"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (Cliente cliente : clienteRepository.findAll()) {
                log.info(cliente.toString());
            }

            log.info("");
        };
    }
}
