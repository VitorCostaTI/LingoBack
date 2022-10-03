package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.HistoricoVenda;
import com.example.LingoLingoBack.Repository.HistoricoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoVendaService {
    @Autowired
    HistoricoVendaRepository historicoVendaRepository;

    public List<HistoricoVenda> findAll(){ return historicoVendaRepository.findAll(); }

    public HistoricoVenda findById(Long id){ return historicoVendaRepository.findById(id).orElseThrow();}

    public HistoricoVenda create(HistoricoVenda historicoVenda){ return historicoVendaRepository.save(historicoVenda); }

    public HistoricoVenda update(HistoricoVenda historicoVenda) {

        var entity = historicoVendaRepository.findById(historicoVenda.getId()).orElseThrow();

        entity.setData(historicoVenda.getData());
        entity.setCliente(historicoVenda.getCliente());
        entity.setContrato(historicoVenda.getContrato());
        entity.setContato(historicoVenda.getContato());
        entity.setNegociacao(historicoVenda.getNegociacao());
        entity.setVerba(historicoVenda.getVerba());
        entity.setDog_id(historicoVenda.getDog_id());

        return historicoVendaRepository.save(historicoVenda);
    }

    public void delete(Long empresa){
        var entity = historicoVendaRepository.findById(empresa).orElseThrow();{
            historicoVendaRepository.delete(entity);
        }
    }
}
