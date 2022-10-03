package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.Maternidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaternidadeRepository extends JpaRepository<Maternidade, Long> {
}
