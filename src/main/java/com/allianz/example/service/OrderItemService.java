package com.allianz.example.service;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemMapper, OrderItemEntityRepository> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    protected OrderItemMapper getMapper() {
        return this.orderItemMapper;
    }

    @Override
    protected OrderItemEntityRepository getRepository() {
        return this.orderItemEntityRepository;
    }
}
