package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Pendencia;
import com.example.LingoLingoBack.Service.PendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/pendencias")
public class PendenciaController {
    @Autowired
    PendenciaService pendenciaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pendencia> findAll(){
        return pendenciaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pendencia findById(@PathVariable(value = "id")Long id){
        return pendenciaService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pendencia create(@RequestBody Pendencia pendencia){
        return pendenciaService.create(pendencia);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pendencia update(@RequestBody Pendencia pendencia){
        return pendenciaService.update(pendencia);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id")Long id){
        pendenciaService.delete(id);
    }
}
