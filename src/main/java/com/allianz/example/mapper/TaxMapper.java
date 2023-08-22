package com.allianz.example.mapper;


import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TaxMapper extends IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {

}
