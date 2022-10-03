package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.Paternidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaternidadeRepository extends JpaRepository<Paternidade, Long> {
}
