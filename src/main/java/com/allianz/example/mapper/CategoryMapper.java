package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

}
