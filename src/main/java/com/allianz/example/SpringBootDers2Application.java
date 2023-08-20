package com.allianz.example;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDers2Application implements CommandLineRunner {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    public static void main(String[] args) {

        SpringApplication.run(SpringBootDers2Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

      //  List<ProductDTO> productDTOS = productService.getAll();

//        ProductEntity product = new ProductEntity();
//        product.setName("Harun");
//        product.setCode("AS749218");
//        product.setCode("RED");
//        product.setQuantity(23);
//        product.setBuyPrice(new BigDecimal(150));
//        product.setSellPrice(new BigDecimal(175));
//        product.setTax(null);
//
//        CategoryEntity category = new CategoryEntity();
//        category.setName("Person");
//
//        product.getCategoryList().add(category);
//        productEntityRepository.save(product);

       // productDTOS.stream().forEach(productEntity -> System.out.println(productEntity));


    }
}
