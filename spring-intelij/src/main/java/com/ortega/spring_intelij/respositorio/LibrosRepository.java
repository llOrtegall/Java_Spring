package com.ortega.spring_intelij.respositorio;

import com.ortega.spring_intelij.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Integer> {

}
