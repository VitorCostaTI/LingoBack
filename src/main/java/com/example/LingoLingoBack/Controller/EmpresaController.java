package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Dog;
import com.example.LingoLingoBack.Model.Empresa;
import com.example.LingoLingoBack.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/empresas")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Empresa> findAll(){
        return empresaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Empresa findById(@PathVariable(value = "id") Long id) {
        return empresaService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.create(empresa);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Empresa update(@RequestBody Empresa empresa) {
        return empresaService.update(empresa);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        empresaService.delete(id);
    }
}

