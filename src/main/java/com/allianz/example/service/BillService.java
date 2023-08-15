package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillEntityRepository> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return this.billEntityRepository;
    }

}
