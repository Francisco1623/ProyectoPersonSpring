package com.jacaranda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.model.Person;
import com.jacaranda.repository.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public List<Person> getPersons(){
		return this.personRepository.findAll();
	}
}
