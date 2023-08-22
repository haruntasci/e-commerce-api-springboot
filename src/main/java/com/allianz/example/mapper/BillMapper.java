package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper extends IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

}
