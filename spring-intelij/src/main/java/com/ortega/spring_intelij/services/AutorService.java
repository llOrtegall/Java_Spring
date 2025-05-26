package com.ortega.spring_intelij.services;

import com.ortega.spring_intelij.model.Autor;
import com.ortega.spring_intelij.respositorio.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutoresRepository repo_autor;

    public List<Autor> getAllAutors() {
        return repo_autor.findAll();
    }

    public Optional<Autor> findAutorById(Integer id) {
        return repo_autor.findById(id);
    }

    // this method is used to update an author <->
    public Autor updateAutorById(Long id, Autor act_autor) {
        Optional<Autor> autorExiste = repo_autor.findById(id.intValue());
        if (autorExiste.isPresent()) {
            Autor autor = autorExiste.get();
            autor.setNombre(act_autor.getNombre());
            autor.setApellido(act_autor.getApellido());
            autor.setNacionalidad(act_autor.getNacionalidad());
            return repo_autor.save(autor);
        } else {
            return null; // or throw an exception
        }
    }

    public Autor insertNewAutor(Autor autor) {
        return (Autor) repo_autor.save(autor);
    }

    public void deleteAutorById(Integer id) {
        repo_autor.deleteById(id);
    }

}
