package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper extends IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {

}
