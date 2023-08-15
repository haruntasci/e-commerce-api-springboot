package com.allianz.example.controller;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("add-others")
    public ResponseEntity<ProductDTO> addOtherRelations(@RequestBody ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.saveWithCategory(productRequestDTO), HttpStatus.OK);
    }

    @GetMapping("get-all-products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }
}