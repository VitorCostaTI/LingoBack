package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.Vermifugacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VermifugacaoRepository extends JpaRepository<Vermifugacao, Long> {
}
