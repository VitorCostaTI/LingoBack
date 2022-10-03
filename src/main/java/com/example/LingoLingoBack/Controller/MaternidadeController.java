package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.HistoricoVenda;
import com.example.LingoLingoBack.Model.Maternidade;
import com.example.LingoLingoBack.Service.HistoricoVendaService;
import com.example.LingoLingoBack.Service.MaternidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/maternidade")
public class MaternidadeController {
    @Autowired
    MaternidadeService maternidadeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Maternidade> findAll(){
        return maternidadeService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Maternidade findById(@PathVariable(value = "id") Long id) {
        return maternidadeService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Maternidade create(@RequestBody Maternidade maternidade){
        return maternidadeService.create(maternidade);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Maternidade update(@RequestBody Maternidade maternidade) {
        return maternidadeService.update(maternidade);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        maternidadeService.delete(id);
    }
}
