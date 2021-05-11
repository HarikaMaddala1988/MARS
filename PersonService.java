package com.spring.crud.service;

import java.util.List;

import com.spring.crud.entity.PersonDto;

public interface PersonService {
	
	public PersonDto createPerson(int id,String firstName,String lastName);
	
	public PersonDto createPersonJson(PersonDto person);
	
	public PersonDto getPersonDetails(int id);
	
	public PersonDto updatePerson(PersonDto person);
	
	public void deletePerson(int id);
	
	public List<PersonDto> getAllPersons();
	
	public long countPerson();

}
