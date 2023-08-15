package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.service.PersonService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<
        PersonEntity,
        PersonDTO,
        PersonRequestDTO,
        PersonMapper,
        PersonEntityRepository,
        PersonService> {

    @Autowired
    PersonService personService;

    @Override
    protected PersonService getService() {
        return this.personService;
    }
}