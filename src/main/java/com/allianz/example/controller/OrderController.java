package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.specification.OrderSpecification;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.OrderStatusRequestDTO;
import com.allianz.example.service.OrderService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController<
        OrderEntity,
        OrderDTO,
        OrderRequestDTO,
        OrderMapper,
        OrderEntityRepository,
        OrderSpecification,
        OrderService> {

    @Autowired
    OrderService orderService;

    @Override
    protected OrderService getService() {
        return this.orderService;
    }

    @PutMapping("/change-order-status/{uuid}")
    public ResponseEntity<String> changeOrderStatus(@RequestBody OrderStatusRequestDTO orderStatusRequest,
                                                    @PathVariable UUID uuid) {
        String orderStatusMessage = orderService.changeOrderStatus(orderStatusRequest, uuid);
        if (orderStatusMessage != null) {
            return new ResponseEntity<>(orderStatusMessage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}