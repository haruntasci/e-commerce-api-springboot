package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends
        BaseService<PersonEntity, PersonDTO, PersonRequestDTO, PersonMapper, PersonEntityRepository> {

    @Autowired
    PersonEntityRepository personEntityRepository;

    @Autowired
    PersonMapper personMapper;

    @Override
    protected PersonMapper getMapper() {
        return this.personMapper;
    }

    @Override
    protected PersonEntityRepository getRepository() {
        return this.personEntityRepository;
    }

    public List<PersonEntity> getPersonNameStartWith(String key) {
        return personEntityRepository.findAllByNameStartingWith(key);
    }

    public List<PersonEntity> getPersonNameIContains(String key) {
        return personEntityRepository.findAllByNameContainsIgnoreCase(key);
    }


    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname) {
        return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

}
