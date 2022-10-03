package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Vermifugacao;
import com.example.LingoLingoBack.Repository.VermifugacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VermifugacaoService {
    @Autowired
    VermifugacaoRepository vermifugacaoRepository;

    public List<Vermifugacao> findAll(){ return vermifugacaoRepository.findAll(); }

    public Vermifugacao findById(Long id){
        return vermifugacaoRepository.findById(id).orElseThrow();
    }
    public Vermifugacao create(Vermifugacao vermifugacao){ return vermifugacaoRepository.save(vermifugacao); }

    public Vermifugacao update(Vermifugacao vermifugacao) {

        var entity = vermifugacaoRepository.findById(vermifugacao.getId()).orElseThrow();

            entity.setVermifugo(vermifugacao.getVermifugo());
            entity.setData(vermifugacao.getData());
            entity.setRepetir(vermifugacao.getRepetir());
            entity.setPeso(vermifugacao.getPeso());
            entity.setCusto(vermifugacao.getCusto());
            entity.setDog_id(vermifugacao.getDog_id());

        return vermifugacaoRepository.save(vermifugacao);
    }

    public void delete(Long vermifugacao){
        var entity = vermifugacaoRepository.findById(vermifugacao).orElseThrow();{
            vermifugacaoRepository.delete(entity);
        }
    }
}
