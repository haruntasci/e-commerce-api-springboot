package com.allianz.example.service;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.specification.OrderItemSpecification;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemMapper, OrderItemEntityRepository, OrderItemSpecification> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    ProductEntityRepository productEntityRepository;

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

    @Override
    protected OrderItemSpecification getSpecification() {
        return null;
    }

    @Override
    public OrderItemDTO save(OrderItemRequestDTO orderItemRequestDTO) {
        ProductEntity product = productEntityRepository.findByUuid(orderItemRequestDTO.getProductUUID()).orElse(null);
        if (product != null) {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setProduct(product);
            orderItem.setOrderPrice(product.getPrice());
            orderItem.setQuantity(orderItemRequestDTO.getQuantity());
            OrderItemEntity savedOrderItem = orderItemEntityRepository.save(orderItem);
            return orderItemMapper.entityToDTO(savedOrderItem);
        } else {
            return null;
        }

    }
}
