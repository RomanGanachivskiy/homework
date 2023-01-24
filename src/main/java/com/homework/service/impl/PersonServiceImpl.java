package com.homework.service.impl;

import com.homework.util.PasswordUtil;
import com.homework.dao.PersonRepository;
import com.homework.dto.PersonDTO;
import com.homework.enums.Role;
import com.homework.model.Person;
import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordUtil passwordUtil;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(PersonDTO personDTO) {
        var person = new Person();
        person.setEmail(personDTO.getEmail());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        var encodedPassword = passwordUtil.encode(personDTO.getPassword());
        person.setPassword(encodedPassword);
        person.setActive(true);
        person.setRole(Role.USER);
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.getById(id);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
