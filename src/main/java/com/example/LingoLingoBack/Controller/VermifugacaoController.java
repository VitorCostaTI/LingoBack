package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Vermifugacao;
import com.example.LingoLingoBack.Service.VermifugacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/vermifugacao")
public class VermifugacaoController {
    @Autowired
    VermifugacaoService vermifugacaoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vermifugacao> findAll(){
        return vermifugacaoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vermifugacao findById(@PathVariable(value = "id")Long id){
        return vermifugacaoService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vermifugacao create(@RequestBody Vermifugacao vermifugacao){
        return vermifugacaoService.create(vermifugacao);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vermifugacao update(@RequestBody Vermifugacao vermifugacao){
        return vermifugacaoService.update(vermifugacao);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id")Long id){
        vermifugacaoService.delete(id);
    }
}
