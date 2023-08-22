package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper extends IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

}
