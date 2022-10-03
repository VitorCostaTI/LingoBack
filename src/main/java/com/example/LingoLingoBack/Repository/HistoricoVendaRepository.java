package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.HistoricoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVendaRepository extends JpaRepository<HistoricoVenda, Long> {
}
