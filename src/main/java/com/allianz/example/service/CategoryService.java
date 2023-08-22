package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.specification.CategorySpecification;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO, CategoryRequestDTO,
        CategoryMapper, CategoryEntityRepository, CategorySpecification> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategorySpecification categorySpecification;

    @Override
    protected CategoryMapper getMapper() {
        return this.categoryMapper;
    }

    @Override
    protected CategoryEntityRepository getRepository() {
        return this.categoryEntityRepository;
    }

    @Override
    protected CategorySpecification getSpecification() {
        return categorySpecification;
    }
}
