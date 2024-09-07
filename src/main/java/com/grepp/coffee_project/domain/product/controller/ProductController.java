package com.grepp.coffee_project.domain.product.controller;

import com.grepp.coffee_project.domain.product.dto.CreateCoffeeDto;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import com.grepp.coffee_project.domain.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;

//    @Autowired , 생성자가 하나뿐이라면 어노테이션 생략해도 자동 객체생성가능하다.
    public ProductController(ProductRepository productRepository, ProductService productService){
        this.productRepository=productRepository;
        this.productService=productService;
    }

    @GetMapping
    public List<Product> getCoffee(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product postCoffee(@RequestBody CreateCoffeeDto createCoffeeDto){
        return productService.makeCoffee(createCoffeeDto);
    }

}

//이처럼 @Autowired로 의존성 주입된 ProductRepository와 ProductService는 각각 하나의 인스턴스만 생성되어 애플리케이션 내에서 공유됩니다.
// 이 인스턴스들은 스프링의 빈 컨테이너에서 관리되며, 여러 곳에서 동일한 빈을 주입받더라도 동일한 인스턴스를 참조하게 됩니다.
