package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.PersonAddressRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PersonService extends
        BaseService<PersonEntity, PersonDTO, PersonRequestDTO, PersonMapper, PersonEntityRepository> {

    @Autowired
    PersonEntityRepository personEntityRepository;

    @Autowired
    AddressEntityRepository addressEntityRepository;

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

    @Transactional
    public PersonDTO addAddressesToPerson(PersonAddressRequestDTO personAddressRequest, UUID personUUID) {
        PersonEntity personEntity = personEntityRepository.findByUuid(personUUID).orElse(null);
        if (personEntity != null) {
            List<AddressEntity> addressEntityList = personEntity.getAddressEntityList();
            if (addressEntityList == null) {
                addressEntityList = new ArrayList<>();
            }
            for (UUID addressUUID : personAddressRequest.getAddressUUIDList()) {
                AddressEntity address = addressEntityRepository.findByUuid(addressUUID).orElse(null);
                if (address != null) {
                    address.setPerson(personEntity);
                    addressEntityList.add(address);
                } else {
                    return null;
                }
            }
            personEntity.setAddressEntityList(addressEntityList);
            PersonEntity savedPerson = personEntityRepository.save(personEntity);
            return personMapper.entityToDTO(savedPerson);
        } else {
            return null;
        }
    }
}
