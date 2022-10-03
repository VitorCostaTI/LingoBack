package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Vacina;
import com.example.LingoLingoBack.Service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/vacinas")
public class VacinaController {
    @Autowired
    VacinaService vacinaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vacina> findAll(){
        return vacinaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vacina findById(@PathVariable(value = "id")Long id){
        return vacinaService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vacina create(@RequestBody Vacina vacina){
        return vacinaService.create(vacina);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vacina update(@RequestBody Vacina vacina){
        return vacinaService.update(vacina);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id")Long id){
        vacinaService.delete(id);
    }
}
