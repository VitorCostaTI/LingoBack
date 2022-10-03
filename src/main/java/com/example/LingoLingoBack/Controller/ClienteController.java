package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Cliente;
import com.example.LingoLingoBack.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findById(@PathVariable(value = "id")Long id){
        return clienteService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.update(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id")Long id){
        clienteService.delete(id);
    }
}
