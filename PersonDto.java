package com.spring.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import lombok.Data;


@Data

@Entity
@Table(name="PERSON")
public class PersonDto {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}

