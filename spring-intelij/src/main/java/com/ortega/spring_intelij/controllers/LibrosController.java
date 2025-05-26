package com.ortega.spring_intelij.controllers;

import com.ortega.spring_intelij.model.Libro;
import com.ortega.spring_intelij.services.LibroService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {
    @Autowired
    private LibroService serv_libro;

    @GetMapping
    public ResponseEntity<List<Libro>> listarTodos() {
        List<Libro> libros = serv_libro.getAllBooks();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarById(@PathVariable Integer id) {
        Optional<Libro> libro = serv_libro.findBookById(id);
        return libro.map(aut -> new ResponseEntity<>(aut, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@Valid @RequestBody Libro libro) {
        Libro nuevoLibro = serv_libro.insertNewBook(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        Libro libroActualizado = serv_libro.updateBookById(id, libro);
        if (libroActualizado != null) {
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        serv_libro.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
