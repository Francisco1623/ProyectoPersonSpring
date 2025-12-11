package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@GetMapping({"/","persons"})
	public String getPersons(Model model) {
		model.addAttribute("listPerson",personService.getPersons());
		return "listPerson";
	}
}
