package com.jacaranda.services;

import java.util.List;
import java.util.Optional;

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
	
	//Listar las personas
	public List<Person> getPersons() throws Exception{
		try {
			return this.personRepository.findAll();
		}catch(Exception e) {
			throw new Exception("Error en listar personas");
		}
		
	}
	
	//Ver persona por id
	public Person getPersonById(Integer id) throws Exception {
		try {
			return this.personRepository.findById(id).orElse(null);
		}catch(Exception e) {
			throw new Exception("Error en ver detalles de la persona");

		}
	}
	
	//Editar persona

		public void editPerson(Person newPer) throws Exception {
			try {
				Person p = this.personRepository.findById(newPer.getId()).orElse(null);
				if(p!=null) {
					p = newPer;
					this.personRepository.save(p);
				}
			}catch(Exception e) {
				throw new Exception("Error en editar la persona");

			}
		}
	
		//Eliminar persona
	public void deletePerson(Person p) throws Exception {
		try {
			this.personRepository.delete(p);
		}catch(Exception e) {
			throw new Exception("Error en eliminar la persona");

		}
	}
	//Añadir persona
	public void addPerson(Person p) throws Exception {
		try {
			this.personRepository.save(p);
		}catch(Exception e) {
			throw new Exception("Error en añadir la persona");

		}
	}
}
