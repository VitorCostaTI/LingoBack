package com.example.LingoLingoBack.Controller;

import com.example.LingoLingoBack.Model.Dog;
import com.example.LingoLingoBack.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/dogs")
public class DogController {
    @Autowired
    DogService dogService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dog> findAll() {
        return dogService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dog findById(@PathVariable(value = "id") Long id) {
        return dogService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog create(@RequestBody Dog dog) {
        return dogService.create(dog);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog update(@RequestBody Dog dog) {
        return dogService.update(dog);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        dogService.delete(id);
    }
}
