package com.spring.crud.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.entity.PersonDto;

public interface PersonRepository extends JpaRepository<PersonDto, Integer> {

}

