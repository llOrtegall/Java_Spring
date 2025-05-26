package com.ortega.spring_intelij.controllers;

import com.ortega.spring_intelij.services.AutorService;
import com.ortega.spring_intelij.model.Autor;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;


@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService serv_autor;

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos(){
        List<Autor> autores = serv_autor.getAllAutors();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarById(@PathVariable Integer id){
        Optional<Autor> autor = serv_autor.findAutorById(id);
        return  autor.map(aut -> new ResponseEntity<>(aut, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Autor> insertarAutor(@Valid @RequestBody Autor in_autor){
        Autor autor = serv_autor.insertNewAutor(in_autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @Valid @RequestBody Autor act_autor){
        Autor autor = serv_autor.updateAutorById(id, act_autor);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
