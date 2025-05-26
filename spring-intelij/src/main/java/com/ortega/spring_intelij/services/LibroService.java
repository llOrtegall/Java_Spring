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

  public List<Libro> getAllBooks() {
    return repo_libro.findAll();
  }

  public Libro insertNewBook(Libro libro) {
    Optional<Autor> autor = autorRepository.findById(libro.getAutor().getId());
    if (autor.isPresent()) {
      libro.setAutor(autor.get());
      return repo_libro.save(libro);
    } else {
      throw new RuntimeException("Autor no encontrado");
    }
    
  }

  public Libro updateBookById(Integer id, Libro upd_libro) {
    Optional<Libro> existingLibro = repo_libro.findById(id);
    if (existingLibro.isPresent()) {
      Libro update = existingLibro.get();

      update.setTitulo(upd_libro.getTitulo());
      update.setGenero(upd_libro.getGenero());
      update.setPaginas(upd_libro.getPaginas());

      Autor getAutor = existingLibro.get().getAutor();

      // check this implementation
      update.setAutor(getAutor);

      return repo_libro.save(update);
    } else {
      throw new RuntimeException("Libro no encontrado");
    }
  }

  public void deleteBookById(Integer id) {
    repo_libro.deleteById(id);
  }

  public Optional<Libro> findBookById(Integer id) {
    return repo_libro.findById(id);
  }
}
