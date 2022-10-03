package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.HistoricoVenda;
import com.example.LingoLingoBack.Service.HistoricoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/historicovenda")
public class HistoricoVendaController {
    @Autowired
    HistoricoVendaService historicoVendaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistoricoVenda> findAll(){
        return historicoVendaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoVenda findById(@PathVariable(value = "id") Long id) {
        return historicoVendaService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoVenda create(@RequestBody HistoricoVenda historicoVenda){
        return historicoVendaService.create(historicoVenda);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoVenda update(@RequestBody HistoricoVenda historicoVenda) {
        return historicoVendaService.update(historicoVenda);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        historicoVendaService.delete(id);
    }
}

