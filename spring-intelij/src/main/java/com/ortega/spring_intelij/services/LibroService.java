package com.ortega.spring_intelij.services;

import com.ortega.spring_intelij.model.Autor;
import com.ortega.spring_intelij.model.Libro;
import com.ortega.spring_intelij.respositorio.AutoresRepository;
import com.ortega.spring_intelij.respositorio.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
  @Autowired
  private LibrosRepository repo_libro;
  @Autowired
  private AutoresRepository autorRepository;

  public Libro guardarLibro(Libro libro) {
    Optional<Autor> autor = autorRepository.findById(libro.getAutor().getId());
    if (autor.isPresent()) {
      libro.setAutor(autor.get());
      return repo_libro.save(libro);
    } else {
      throw new RuntimeException("Autor no encontrado");
    }
    
  }

  public List<Libro> listarLibros() {
    return repo_libro.findAll();
  }

  public void eliminarLibro(Integer id) {
    repo_libro.deleteById(id);
  }

  public Optional<Libro> buscarLibroPorId(Integer id) {
    return repo_libro.findById(id);
  }
}
