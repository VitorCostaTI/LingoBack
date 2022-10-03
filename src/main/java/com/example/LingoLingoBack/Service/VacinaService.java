package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Vacina;
import com.example.LingoLingoBack.Repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> findAll(){ return vacinaRepository.findAll(); }

    public Vacina findById(Long id){
        return vacinaRepository.findById(id).orElseThrow();
    }
    public Vacina create(Vacina vacina){ return vacinaRepository.save(vacina); }

    public Vacina update(Vacina vacina) {

        var entity = vacinaRepository.findById(vacina.getId()).orElseThrow();

            entity.setVacina(vacina.getVacina());
            entity.setData(vacina.getData());
            entity.setRevacinar(vacina.getRevacinar());
            entity.setCusto(vacina.getCusto());
            entity.setDog_id(vacina.getDog_id());

        return vacinaRepository.save(vacina);
    }

    public void delete(Long vacina){
        var entity = vacinaRepository.findById(vacina).orElseThrow();{
            vacinaRepository.delete(entity);
        }
    }
}
