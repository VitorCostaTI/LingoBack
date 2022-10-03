package com.example.LingoLingoBack.Service;

import com.example.LingoLingoBack.Model.Cliente;
import com.example.LingoLingoBack.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){

        var entity = clienteRepository.findById(cliente.getId()).orElseThrow();

        entity.setNome(cliente.getNome());
        entity.setNacionalidade(cliente.getNacionalidade());
        entity.setIdentidade(cliente.getIdentidade());
        entity.setCpf(cliente.getCpf());
        entity.setCep(cliente.getCep());
        entity.setLogradouro(cliente.getLogradouro());
        entity.setBairro(cliente.getBairro());
        entity.setCidade(cliente.getCidade());
        entity.setUf(cliente.getUf());
        entity.setContato(cliente.getContato());
        entity.setComplemento(cliente.getComplemento());
        entity.setEmail(cliente.getEmail());

        return clienteRepository.save(cliente);
    }

    public void delete(Long cliente){
        var entity = clienteRepository.findById(cliente).orElseThrow();{
            clienteRepository.delete(entity);
        }
    }
}
