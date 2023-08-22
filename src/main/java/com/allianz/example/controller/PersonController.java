package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.specification.PersonSpecification;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonAddressRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.service.PersonService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<
        PersonEntity,
        PersonDTO,
        PersonRequestDTO,
        PersonMapper,
        PersonEntityRepository,
        PersonSpecification,
        PersonService> {

    @Autowired
    PersonService personService;

    @Override
    protected PersonService getService() {
        return this.personService;
    }

    @PutMapping("/add-addresses-to-person/{uuid}")
    public ResponseEntity<PersonDTO> addAddressesToPerson(@RequestBody PersonAddressRequestDTO personAddressRequest,
                                                          @PathVariable UUID uuid) {
        PersonDTO person = personService.addAddressesToPerson(personAddressRequest, uuid);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}