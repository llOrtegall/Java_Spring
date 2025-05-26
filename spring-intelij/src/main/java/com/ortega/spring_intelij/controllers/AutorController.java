package com.ortega.spring_intelij.controllers;

import com.ortega.spring_intelij.model.Autor;
import com.ortega.spring_intelij.services.AutorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService serv_autor;

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos(){
        List<Autor> autores = serv_autor.listarAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarById(@PathVariable Integer id){
        Optional<Autor> autor = serv_autor.buscarAutorPorId(id);
        return  autor.map(aut -> new ResponseEntity<>(aut, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Autor> insertarAutor(@Valid @RequestBody Autor in_autor){
        Autor autor = serv_autor.guardarAutor(in_autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @Valid @RequestBody Autor act_autor){
        Autor autor = serv_autor.actualizarAutor(id, act_autor);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
