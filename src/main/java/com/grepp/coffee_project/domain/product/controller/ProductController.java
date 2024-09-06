package com.grepp.coffee_project.domain.product.controller;

import com.grepp.coffee_project.domain.product.dto.CreateCoffeeDto;
import com.grepp.coffee_project.domain.product.entity.ProductEntity;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductEntity> getCoffee(){
        return productRepository.findAll();
    }

    @PostMapping
    public ProductEntity postCoffee(@RequestBody CreateCoffeeDto createCoffeeDto){
        ProductEntity product= new ProductEntity();
        product.setProduct_name(createCoffeeDto.getProduct_name());
        product.setCategory(createCoffeeDto.getCategory());
        product.setPrice(createCoffeeDto.getPrice());
        product.setDescription(createCoffeeDto.getDescription());

        productRepository.save(product);
        return product;

    }

}
