package com.grepp.coffee_project.domain.product.service;

import com.grepp.coffee_project.domain.product.dto.CreateCoffeeDto;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product makeCoffee(CreateCoffeeDto createCoffeeDto){
        //if admin 이면 가능! 예외처리 나중에
        Product product= new Product();
        product.setProduct_name(createCoffeeDto.getProduct_name());
        product.setCategory(createCoffeeDto.getCategory());
        product.setPrice(createCoffeeDto.getPrice());
        product.setDescription(createCoffeeDto.getDescription());

        productRepository.save(product);
        return product;
    }
}
