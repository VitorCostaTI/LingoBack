package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.HistoricoSaude;
import com.example.LingoLingoBack.Repository.HistoricoSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoSaudeService {

    @Autowired
    HistoricoSaudeRepository historicoSaudeRepository;

    public List<HistoricoSaude> findAll(){ return historicoSaudeRepository.findAll(); }

    public HistoricoSaude findById(Long id){ return historicoSaudeRepository.findById(id).orElseThrow();}

    public HistoricoSaude create(HistoricoSaude historicoSaude){ return historicoSaudeRepository.save(historicoSaude); }

    public HistoricoSaude update(HistoricoSaude historicoSaude) {

        var entity = historicoSaudeRepository.findById(historicoSaude.getId()).orElseThrow();

         entity.setData(historicoSaude.getData());
         entity.setEvento(historicoSaude.getEvento());
         entity.setCusto(historicoSaude.getTratamento());
         entity.setCusto(historicoSaude.getCusto());
         entity.setDog_id(historicoSaude.getDog_id());

        return historicoSaudeRepository.save(historicoSaude);
    }

    public void delete(Long empresa){
        var entity = historicoSaudeRepository.findById(empresa).orElseThrow();{
            historicoSaudeRepository.delete(entity);
        }
    }
}
