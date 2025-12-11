package com.jacaranda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
