package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface AddressMapper extends IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {

}
