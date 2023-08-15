package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxEntity, TaxDTO, TaxRequestDTO, TaxMapper, TaxEntityRepository> {
    @Autowired
    TaxEntityRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    @Override
    protected TaxMapper getMapper() {
        return this.taxMapper;
    }

    @Override
    protected TaxEntityRepository getRepository() {
        return this.taxEntityRepository;
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {
        return super.update(uuid, taxRequestDTO);
    }
}
