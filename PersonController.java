package com.spring.crud.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.entity.PersonDto;
import com.spring.crud.exceptions.CustomException;
import com.spring.crud.service.PersonServiceImpl;



@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServiceImpl personService;
	
	@PostMapping("/{id}/{firstName}/{lastName}")
	public ResponseEntity<?> addPerson(@PathVariable int id, String firstName, String lastName) {
		PersonDto personDetails = personService.createPerson(id,firstName,lastName);
		return new ResponseEntity<>(personDetails,HttpStatus.CREATED);
		
		
	}
	
	@PostMapping
	public ResponseEntity<?> addPersonJson( @RequestBody PersonDto person) {
		PersonDto personDetails =  personService.createPersonJson(person);
		return new ResponseEntity<>(personDetails,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPerson(@PathVariable(required=true) int id) {
		PersonDto personDetails = personService.getPersonDetails(id);
		return new ResponseEntity<>(personDetails,HttpStatus.OK);
		
	}
	
	@GetMapping("/getPersons")
	public ResponseEntity<?>  getAllPersons() {
		List<PersonDto> personList = personService.getAllPersons();
		return new ResponseEntity<>(personList,HttpStatus.OK);
	}
	
	@PutMapping("/updatePerson")
	public ResponseEntity<?> updatePerson(@RequestBody PersonDto person) {
		if(person.getId() == null || person.getId()<0) {
			throw new CustomException("Invalid Id");
		}
		PersonDto personDetails =personService.updatePerson(person);
		return new ResponseEntity<>(personDetails,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(required = true) int id) {
		try {
			if(id <=0) {
				throw new CustomException("Invalid Id");
			}
		
			personService.deletePerson(id);
		}
		catch (Exception e) {
			throw new CustomException("Error while deleting the record");
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("message", "Record Deleted ID ::"+id);
		return new ResponseEntity<Map>(map,HttpStatus.OK);
		
	
	}
	
	@GetMapping("/countPersons")
	public ResponseEntity<?> countPersons( ) {
		long personCount = personService.countPerson();
		return new ResponseEntity<>(personCount,HttpStatus.OK);
	
	}
}
