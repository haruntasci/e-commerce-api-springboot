package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO,
        ProductMapper, ProductEntityRepository> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryService categoryService;

    @Override
    protected ProductMapper getMapper() {
        return this.productMapper;
    }

    @Override
    protected ProductEntityRepository getRepository() {
        return this.productEntityRepository;
    }


    public List<ProductDTO> getAll(){
        List<ProductEntity> productEntities = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntities);
    }



    @Transactional
    public ProductDTO saveWithCategory(ProductRequestDTO productRequestDTO) {

        Set<CategoryRequestDTO> categoryRequestDTOS = new HashSet<>(new ArrayList<>(productRequestDTO.getCategoryList()));
        //productRequestDTO.setCategoryList(null);


        ProductEntity productEntity = productMapper.requestDTOToEntity(productRequestDTO);
        ProductEntity savedProductEntity = productEntityRepository.save(productEntity);


        Set<CategoryEntity> associatedCategories = new HashSet<>();
        for (CategoryRequestDTO categoryRequestDTO : categoryRequestDTOS) {
            CategoryDTO categoryDTO = categoryService.getByUUID(categoryRequestDTO.getUuid());
            CategoryEntity categoryEntity = categoryMapper.dtoToEntity(categoryDTO);
            associatedCategories.add(categoryEntity);
        }

        savedProductEntity.setCategoryList(associatedCategories);
        productEntityRepository.save(savedProductEntity);

        return productMapper.entityToDTO(productEntity);
    }
}
