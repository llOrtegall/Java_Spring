package com.ortega.spring_intelij.respositorio;

import com.ortega.spring_intelij.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository extends JpaRepository<Autor, Integer> {
}
