package com.allianz.example.controller;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.specification.SellerSpecification;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.service.SellerService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController extends BaseController<
        SellerEntity,
        SellerDTO,
        SellerRequestDTO,
        SellerMapper,
        SellerEntityRepository,
        SellerSpecification,
        SellerService> {

    @Autowired
    SellerService sellerService;

    @Override
    protected SellerService getService() {
        return this.sellerService;
    }
}
