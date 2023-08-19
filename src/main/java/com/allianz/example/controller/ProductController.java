package com.allianz.example.controller;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductCategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController<
        ProductEntity,
        ProductDTO,
        ProductRequestDTO,
        ProductMapper,
        ProductEntityRepository,
        ProductService> {

    @Autowired
    ProductService productService;

    @Override
    protected ProductService getService() {
        return this.productService;
    }

    @PutMapping("/add-categories/{uuid}")
    public ResponseEntity<ProductDTO> addCategoriesToProduct(@RequestBody ProductCategoryRequestDTO productCategoryRequest,
                                                             @PathVariable UUID uuid) {
        ProductDTO productDTO = productService.addCategoriesToProduct(productCategoryRequest, uuid);
        if (productDTO != null) {
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/add-tax")
    public ResponseEntity<ProductDTO> addTaxToProduct(@RequestParam UUID taxUUID, @RequestParam UUID productUUID){
        ProductDTO productDTO = productService.addTaxToProduct(taxUUID,productUUID);
        if (productDTO != null) {
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




}