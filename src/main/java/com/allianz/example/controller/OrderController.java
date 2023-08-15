package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.service.OrderService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController<
        OrderEntity,
        OrderDTO,
        OrderRequestDTO,
        OrderMapper,
        OrderEntityRepository,
        OrderService> {

    @Autowired
    OrderService orderService;

    @Override
    protected OrderService getService() {
        return this.orderService;
    }
}