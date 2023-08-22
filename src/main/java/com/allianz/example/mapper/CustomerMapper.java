package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
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
public interface CustomerMapper extends IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

}
