package com.jacaranda.model;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Entity
@Table(name="persona")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="El nombre no puede estar vacío")
	@Length(min=3,max=30, message="El nombre tiene que estar entre 3 y 30 caracteres")
	@Column(name="nombre")
	private String name;
	
	@NotEmpty(message="El apellido no puede estar vacío")
	@Length(min=7,max=40, message="Los apellidos tiene que estar entre 7 y 40 caracteres")
	@Column(name="apellidos")
	private String surnames;
	
	@NotNull(message = "Debe seleccionar el sexo")	
	@Column(name="sexo")
	private Boolean sex;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Integer id, String name, String surnames, Boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.surnames = surnames;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
