package com.richard.api.ws.controller;

import com.richard.api.ws.model.Cliente;
import com.richard.api.ws.service.ClienteService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author richard
 */
@RestController
@RequestMapping(value="/admin")
public class ClienteController {
   
    @Autowired
    private ClienteService clienteService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
       
        Cliente client = clienteService.save(cliente);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodos() {
        
        Collection clients = clienteService.buscarTodos();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}" )
    public ResponseEntity<Cliente> excluir(@PathVariable Long id) {
       
        Cliente client  = clienteService.buscaPorId(id);
        
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        clienteService.excluir(client);
                
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente) {
       
        Cliente client = clienteService.alterar(cliente);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
       
        Cliente client  = clienteService.buscaPorId(id);
        
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    
    
    
    
   
}
