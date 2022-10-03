package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Maternidade;
import com.example.LingoLingoBack.Repository.MaternidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaternidadeService {
    @Autowired
    MaternidadeRepository maternidadeRepository;

    public List<Maternidade> findAll(){ return maternidadeRepository.findAll(); }

    public Maternidade findById(Long id){
        return maternidadeRepository.findById(id).orElseThrow();
    }
    public Maternidade create(Maternidade maternidade){ return maternidadeRepository.save(maternidade); }

    public Maternidade update(Maternidade maternidade) {

        var entity = maternidadeRepository.findById(maternidade.getId()).orElseThrow();

        entity.setData(maternidade.getData());
        entity.setCio(maternidade.getCio());
        entity.setParceiro(maternidade.getParceiro());
        entity.setTipoCruzamento(maternidade.getTipoCruzamento());
        entity.setTempoGestacao(maternidade.getTempoGestacao());
        entity.setCriaMachos(maternidade.getCriaMachos());
        entity.setCriaFemeas(maternidade.getCriaFemeas());
        entity.setAbortos(maternidade.getAbortos());
        entity.setCusto(maternidade.getCusto());
       /* entity.setDog_id(maternidade.getDog_id());*/

        return maternidadeRepository.save(maternidade);
    }

    public void delete(Long maternidade){
        var entity = maternidadeRepository.findById(maternidade).orElseThrow();{
            maternidadeRepository.delete(entity);
        }
    }
}
