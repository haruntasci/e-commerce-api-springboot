package com.allianz.example.controller;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
public class BillController extends BaseController<
        BillEntity,
        BillDTO,
        BillRequestDTO,
        BillMapper,
        BillEntityRepository,
        BillService> {

    @Autowired
    BillService billService;

    @Override
    protected BillService getService() {
        return this.billService;
    }
}