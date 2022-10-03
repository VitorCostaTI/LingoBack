package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.HistoricoSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoSaudeRepository extends JpaRepository<HistoricoSaude, Long> {
}
