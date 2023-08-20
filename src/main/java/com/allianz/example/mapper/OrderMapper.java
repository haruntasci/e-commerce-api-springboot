package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {

        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        if (entity.getCustomer() != null) {
            dto.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        }
        dto.setOrderStatus(entity.getOrderStatus());
        if (entity.getOrderItemList() != null) {
            dto.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));

        }
        dto.setTotalAmount(entity.getTotalAmount());

        return dto;


    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        if (dto.getCustomer() != null) {
            entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        }
        entity.setOrderStatus(dto.getOrderStatus());
        if (dto.getOrderItemList() != null) {
            entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));

        }
        entity.setTotalAmount(dto.getTotalAmount());
        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity order : orderEntities) {
            orderDTOList.add(entityToDTO(order));
        }
        return orderDTOList;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();
        return entity;
    }

    @Override
    public List<OrderEntity> requestDtoListTOEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (OrderRequestDTO orderRequestDTO : orderRequestDTOS) {
            orderEntityList.add(requestDTOToEntity(orderRequestDTO));
        }
        return orderEntityList;
    }

    @Override
    public OrderEntity requestDtoToExistEntity(OrderEntity entity, OrderRequestDTO orderRequestDTO) {
//        entity.setCustomer(customerMapper.requestDTOToEntity(orderRequestDTO.getCustomer()));
//        entity.setOrderItemList(orderItemMapper.requestDtoListTOEntityList(orderRequestDTO.getOrderItemList()));
//        entity.setOrderStatus(orderRequestDTO.getOrderStatus());
//        entity.setTotalAmount(orderRequestDTO.getTotalAmount());
        return entity;
    }

    @Override
    public PageDTO<OrderDTO> pageEntityToPageDTO(Page<OrderEntity> entityPage) {
        PageDTO<OrderDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
