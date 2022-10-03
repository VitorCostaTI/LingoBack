package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Cliente;
import com.example.LingoLingoBack.Model.Dog;
import com.example.LingoLingoBack.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> findAll(){
        return dogRepository.findAll();
    }

    public Dog findById(Long id){
        return dogRepository.findById(id).orElseThrow();
    }

    public Dog create(Dog dog){
        return dogRepository.save(dog);
    }

    public Dog update(Dog dog){

        var entity = dogRepository.findById(dog.getId()).orElseThrow();

        entity.setDog(dog.getDog());
        entity.setSexo(dog.getSexo());
        entity.setNascimento(dog.getNascimento());
        entity.setRaca(dog.getRaca());
        entity.setCor(dog.getCor());
        entity.setPai(dog.getPai());
        entity.setMae(dog.getMae());
        entity.setRegistro(dog.getRegistro());
        entity.setCusto(dog.getCusto());

        return dogRepository.save(dog);
    }

    public void delete(Long cliente){
        var entity = dogRepository.findById(cliente).orElseThrow();{
            dogRepository.delete(entity);
        }
    }
}
