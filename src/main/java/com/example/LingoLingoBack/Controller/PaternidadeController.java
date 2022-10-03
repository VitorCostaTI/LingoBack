package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Paternidade;
import com.example.LingoLingoBack.Service.PaternidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/paternidade")
public class PaternidadeController {
    @Autowired
    PaternidadeService paternidadeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paternidade> findAll(){
        return paternidadeService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Paternidade findById(@PathVariable(value = "id")Long id){
        return paternidadeService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Paternidade create(@RequestBody Paternidade paternidade){
        return paternidadeService.create(paternidade);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Paternidade update(@RequestBody Paternidade paternidade){
        return paternidadeService.update(paternidade);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id")Long id){
        paternidadeService.delete(id);
    }
}
