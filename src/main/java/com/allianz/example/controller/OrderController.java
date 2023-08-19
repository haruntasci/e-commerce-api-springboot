package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.OrderStatusRequestDTO;
import com.allianz.example.service.OrderService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @PutMapping("/change-order-status/{uuid}")
    public ResponseEntity<OrderDTO> changeOrderStatus(@RequestBody OrderStatusRequestDTO orderStatusRequest, UUID uuid) {
        OrderDTO order = orderService.changeOrderStatus(orderStatusRequest, uuid);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}