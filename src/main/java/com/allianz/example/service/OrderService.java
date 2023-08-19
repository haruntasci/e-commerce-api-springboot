package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.OrderStatusRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO,
        OrderMapper, OrderEntityRepository> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    protected OrderMapper getMapper() {
        return this.orderMapper;
    }

    @Override
    protected OrderEntityRepository getRepository() {
        return this.orderEntityRepository;
    }

    public OrderDTO changeOrderStatus(OrderStatusRequestDTO orderStatusRequest, UUID orderUUID) {
        OrderEntity order = orderEntityRepository.findByUuid(orderUUID).orElse(null);
        if (order != null) {
            order.setOrderStatus(orderStatusRequest.getOrderStatus());
            OrderEntity savedOrder = orderEntityRepository.save(order);
            return orderMapper.entityToDTO(savedOrder);
        } else {
            return null;
        }
    }

    @Override
    public OrderDTO save(OrderRequestDTO orderRequest) {
        CustomerEntity customer = customerEntityRepository.findByUuid(orderRequest.getCustomerUUID()).orElse(null);
        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
        for (UUID uuid : orderRequest.getOrderItemUUIDList()) {
            OrderItemEntity orderItem = orderItemEntityRepository.findByUuid(uuid).orElse(null);
            if (orderItem != null) {
                orderItemEntityList.add(orderItem);
            } else {
                return null;
            }
        }
        if (customer != null) {
            OrderEntity order = new OrderEntity();
            order.setCustomer(customer);
            order.setOrderItemList(orderItemEntityList);
            OrderEntity savedOrder = orderEntityRepository.save(order);
            return orderMapper.entityToDTO(savedOrder);
        } else {
            return null;
        }
    }
}
