package com.ortega.hibernate.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.ortega.hibernate.entidades.Person;

public interface Repo_Person extends CrudRepository<Person, Long> {
   
}

   
