package com.ortega.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ortega.hibernate.repositorys.Person;

@SpringBootApplication
public class HibernateApplication  implements CommandLineRunner{

	@Autowired
	private Person personRepo;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = (List<Person>) personRepo.findAll();
		persons.stream().forEach(p -> System.out.println(p));
	}

}
