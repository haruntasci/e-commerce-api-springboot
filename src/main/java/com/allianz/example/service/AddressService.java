package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.specification.AddressSpecification;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressEntity, AddressDTO, AddressRequestDTO,
        AddressMapper,AddressEntityRepository, AddressSpecification> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressSpecification addressSpecification;

    @Override
    protected AddressMapper getMapper() {
        return this.addressMapper;
    }

    @Override
    protected AddressEntityRepository getRepository() {
        return this.addressEntityRepository;
    }

    @Override
    protected AddressSpecification getSpecification() {
        return addressSpecification;
    }

}
