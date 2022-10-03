package com.example.LingoLingoBack.Repository;

import com.example.LingoLingoBack.Model.Pendencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendenciaRepository extends JpaRepository<Pendencia, Long> {
}
