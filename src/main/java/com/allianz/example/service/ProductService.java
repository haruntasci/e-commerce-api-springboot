package com.allianz.example.service;

import com.allianz.example.database.entity.*;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.database.specification.ProductSpecification;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductCategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO,
        ProductMapper, ProductEntityRepository, ProductSpecification> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductSpecification productSpecification;

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    TaxEntityRepository taxEntityRepository;

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

    @Override
    protected ProductSpecification getSpecification() {
        return productSpecification;
    }

    @Transactional
    public ProductDTO addCategoriesToProduct(ProductCategoryRequestDTO productCategoryRequest, UUID productUUID) {

        ProductEntity product = productEntityRepository.findByUuid(productUUID).orElse(null);
        if (product != null) {
            Set<CategoryEntity> categoryEntities = product.getCategoryList();
            if (categoryEntities == null) {
                categoryEntities = new HashSet<>();
            }
            for (UUID categoryUUID : productCategoryRequest.getCategoryUUIDList()) {
                CategoryEntity category = categoryEntityRepository.findByUuid(categoryUUID).orElse(null);
                if (category != null) {
                    categoryEntities.add(category);
                } else {
                    return null;
                }
            }
            product.setCategoryList(categoryEntities);
            ProductEntity savedProduct = productEntityRepository.save(product);
            return productMapper.entityToDTO(savedProduct);
        } else {
            return null;
        }

    }

    @Transactional
    public ProductDTO addTaxToProduct(UUID taxUUID, UUID productUUID) {
        ProductEntity product = productEntityRepository.findByUuid(productUUID).orElse(null);
        if (product != null) {
            TaxEntity tax = taxEntityRepository.findByUuid(taxUUID).orElse(null);
            if (tax != null) {
                product.setTax(tax);
                ProductEntity savedProduct = productEntityRepository.save(product);
                return productMapper.entityToDTO(savedProduct);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void updateProductQuantity(OrderEntity order) {
        for (OrderItemEntity orderItem : order.getOrderItemList()) {
            ProductEntity product = orderItem.getProduct();
            product.setQuantity(product.getQuantity() - orderItem.getQuantity());
            productEntityRepository.save(product);
        }
    }


}
