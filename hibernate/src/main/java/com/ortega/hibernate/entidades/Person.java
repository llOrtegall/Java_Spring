package com.ortega.hibernate.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-incrementing primary key
  private Long id;

  private String names;

  private String lastNames;

  @Column(name = "lenguajes")
  private String lenguaje;

  public Person() {
    // Default constructor for JPA
  }

  public Person(Long id, String names, String lastNames, String lenguaje) {
    this.id = id;
    this.names = names;
    this.lastNames = lastNames;
    this.lenguaje = lenguaje;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  public String getLenguaje() {
    return lenguaje;
  }

  public void setLenguaje(String lenguaje) {
    this.lenguaje = lenguaje;
  }

  @Override
  public String toString() {
    return "[id=" + id + ", names=" + names + ", lastNames=" + lastNames + ", lenguaje=" + lenguaje + "]";
  }
}
