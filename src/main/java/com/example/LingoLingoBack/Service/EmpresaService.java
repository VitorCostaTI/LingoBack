package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Cliente;
import com.example.LingoLingoBack.Model.Empresa;
import com.example.LingoLingoBack.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> findAll(){ return empresaRepository.findAll(); }

    public Empresa findById(Long id){
        return empresaRepository.findById(id).orElseThrow();
    }
    public Empresa create(Empresa empresa){ return empresaRepository.save(empresa); }

    public Empresa update(Empresa empresa) {

        var entity = empresaRepository.findById(empresa.getId()).orElseThrow();

        entity.setEmpresa(empresa.getEmpresa());
        entity.setRepresentante(empresa.getRepresentante());
        entity.setFone(empresa.getFone());
        entity.setCnpj(empresa.getCnpj());
        entity.setCep(empresa.getCep());
        entity.setLogradouro(empresa.getLogradouro());
        entity.setBairro(empresa.getBairro());
        entity.setCidade(empresa.getCidade());
        entity.setUf(empresa.getUf());
        entity.setComplemento(empresa.getComplemento());

        return empresaRepository.save(empresa);
    }

    public void delete(Long empresa){
        var entity = empresaRepository.findById(empresa).orElseThrow();{
            empresaRepository.delete(entity);
        }
    }
}
