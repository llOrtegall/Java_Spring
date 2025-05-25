package com.ortega.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ortega.hibernate.entidades.Person;
import com.ortega.hibernate.repositorys.Repo_Person;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

  @Autowired
  private Repo_Person repoPerson;

  @GetMapping
  public List<Person> getAll(){
    return (List<Person>) repoPerson.findAll();
  }
  
}
