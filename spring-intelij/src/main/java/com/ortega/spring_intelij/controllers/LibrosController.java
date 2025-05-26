package com.ortega.spring_intelij.controllers;

import com.ortega.spring_intelij.model.Libro;
import com.ortega.spring_intelij.services.LibroService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {
    @Autowired
    private LibroService serv_libro;

    @GetMapping
    public ResponseEntity<List<Libro>> listarTodos() {
        List<Libro> libros = serv_libro.listarLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> buscarById(@PathVariable Integer id){
        Optional<Libro> libro = serv_libro.buscarLibroPorId(id);
        return  libro.map(aut -> new ResponseEntity<>(aut, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@Valid @RequestBody Libro libro) {
        Libro nuevoLibro = serv_libro.guardarLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }
}
