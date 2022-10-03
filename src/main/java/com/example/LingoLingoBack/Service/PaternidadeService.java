package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Paternidade;
import com.example.LingoLingoBack.Repository.PaternidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaternidadeService {
    @Autowired
    PaternidadeRepository paternidadeRepository;

    public List<Paternidade> findAll(){ return paternidadeRepository.findAll(); }

    public Paternidade findById(Long id){
        return paternidadeRepository.findById(id).orElseThrow();
    }
    public Paternidade create(Paternidade paternidade){ return paternidadeRepository.save(paternidade); }

    public Paternidade update(Paternidade paternidade) {

        var entity = paternidadeRepository.findById(paternidade.getId()).orElseThrow();

        entity.setData(paternidade.getData());
        entity.setParceira(paternidade.getParceira());
        entity.setTipoCruzamento(paternidade.getTipoCruzamento());
        entity.setAcordo(paternidade.getAcordo());
        entity.setVerba(paternidade.getVerba());
        entity.setCriaMachos(paternidade.getCriaMachos());
        entity.setCriaFemeas(paternidade.getCriaFemeas());
        entity.setTempoGestacao(paternidade.getTempoGestacao());
        entity.setCusto(paternidade.getCusto());
        entity.setDog_id(paternidade.getDog_id());

        return paternidadeRepository.save(paternidade);
    }

    public void delete(Long paternidade){
        var entity = paternidadeRepository.findById(paternidade).orElseThrow();{
            paternidadeRepository.delete(entity);
        }
    }
}
