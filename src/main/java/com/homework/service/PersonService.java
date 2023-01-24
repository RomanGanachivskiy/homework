package com.homework.service;

import com.homework.model.Person;
import com.homework.dto.PersonDTO;

import java.util.List;

public interface PersonService {
 List<Person> getAllPersons();

 Person savePerson(PersonDTO personDTO);

 Person getPersonById(Long id);

 Person getPersonByEmail(String email);
}
