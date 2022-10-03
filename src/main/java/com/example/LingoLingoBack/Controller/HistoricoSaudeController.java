package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.HistoricoSaude;
import com.example.LingoLingoBack.Service.HistoricoSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/historicosaude")
public class HistoricoSaudeController {
    @Autowired
    HistoricoSaudeService historicoSaudeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistoricoSaude> findAll(){
        return historicoSaudeService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoSaude findById(@PathVariable(value = "id") Long id) {
        return historicoSaudeService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoSaude create(@RequestBody HistoricoSaude historicoSaude){
        return historicoSaudeService.create(historicoSaude);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HistoricoSaude update(@RequestBody HistoricoSaude historicoSaude) {
        return historicoSaudeService.update(historicoSaude);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        historicoSaudeService.delete(id);
    }
}
