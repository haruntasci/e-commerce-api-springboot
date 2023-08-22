package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface SettingMapper extends IBaseMapper<SettingDTO, SettingEntity, SettingRequestDTO> {

}
