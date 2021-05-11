package com.spring.crud.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dao.PersonRepository;
import com.spring.crud.entity.PersonDto;
import com.spring.crud.exceptions.CustomException;





@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public PersonDto createPerson(int id,String firstName,String lastName) {
		PersonDto person = new PersonDto();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return personRepository.save(person);
	}
	
	@Override
	public PersonDto createPersonJson(PersonDto person) {
		
		return personRepository.save(person);
	}
	

	@Override
	public PersonDto getPersonDetails(int id) {
		Optional<PersonDto> personDetails = personRepository.findById(id);
		
		if(!personDetails.isPresent()) {
			throw new CustomException("No Record Found");
		}
		return personDetails.get();
	}
	
	@Override
	public List<PersonDto> getAllPersons() {
		return personRepository.findAll();
	}
	
	@Override
	public PersonDto updatePerson(PersonDto person) {
		
		try {
				PersonDto personObj=  personRepository.findById(person.getId()).get();
				if(null == personObj) {
					throw new CustomException("No Records found");
		}

				return personRepository.save(person);
		}
	
	catch(Exception e) {
		throw new CustomException("Error while updating record");
		
			}
		}
	
	@Override
	public void deletePerson(int id) {
		try {
			PersonDto personObj = personRepository.findById(id).get();
			if(null == personObj) {
				throw new CustomException("No Record found");
			}
			personRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new CustomException("Unable to delete record");
		}
	
	}
	
	@Override
	public long countPerson() {
		return personRepository.count();
		
	}
	
	

}
