package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper extends IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {

}
