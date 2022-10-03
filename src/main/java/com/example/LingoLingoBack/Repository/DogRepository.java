package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.Documentos.RelContrato;
import com.example.LingoLingoBack.Model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DogRepository extends JpaRepository <Dog, Long> {
    @Query(value = "select " +
            "c.nome as nome, " +
            "c.cpf as cpf, " +
            "c.logradouro as logradouro, " +
            "c.complemento as complemento, " +
            "c.cidade as cidade, " +
            "c.uf as uf, " +
            "c.cep as cep, " +
            "d.raca as raca, " +
            "d.cor as cor, " +
            "d.nascimento as nascimento, " +
            "d.sexo as sexo " +
            "from dog d " +
            "join cliente c on (d.id_cliente = c.id)", nativeQuery = true)
    List<RelContrato> getRelContratos(@Param("id") Long id);
}
