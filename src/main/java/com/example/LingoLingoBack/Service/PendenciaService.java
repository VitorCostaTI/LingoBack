package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Pendencia;
import com.example.LingoLingoBack.Repository.PendenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendenciaService {
    @Autowired
    PendenciaRepository pendenciaRepository;

    public List<Pendencia> findAll(){
        return pendenciaRepository.findAll();
    }

    public Pendencia findById(Long id){
        return pendenciaRepository.findById(id).orElseThrow();
    }

    public Pendencia create( Pendencia pendencia){
        return pendenciaRepository.save(pendencia);
    }

    public Pendencia update(Pendencia pendencia){
        var entity = pendenciaRepository.findById(pendencia.getId()).orElseThrow();

            entity.setNome(pendencia.getNome());
            entity.setData(pendencia.getData());
            entity.setDescricao(pendencia.getDescricao());

        return pendenciaRepository.save(pendencia);
    }

    public void delete(Long pendencia) {
        var entity = pendenciaRepository.findById(pendencia).orElseThrow();
            pendenciaRepository.delete(entity);
    }
}

