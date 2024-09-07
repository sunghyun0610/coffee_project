package com.grepp.coffee_project.domain.product.service;

import com.grepp.coffee_project.domain.product.dto.CreateCoffeeDto;
import com.grepp.coffee_project.domain.product.dto.ResponseDto;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseDto makeCoffee(CreateCoffeeDto createCoffeeDto){

        ResponseDto responseDto = new ResponseDto();//DTO는 보통 의존성주입 안하고 직접 생성
        //if admin 이면 가능! 예외처리 나중에
        Product product= new Product();
        product.setProduct_name(createCoffeeDto.getProduct_name());
        product.setCategory(createCoffeeDto.getCategory());
        if (createCoffeeDto.getPrice() < 0) {
            throw new IllegalArgumentException("가격은 0보다 작을 수 없습니다.");
        }
        product.setPrice(createCoffeeDto.getPrice());
        product.setDescription(createCoffeeDto.getDescription());

        productRepository.save(product);//엔티티 repository통해 db저장

        responseDto.setProductId(product.getProduct_id());
        responseDto.setProductName(product.getProduct_name());
        responseDto.setCategory(product.getCategory());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        responseDto.setOrderItems(product.getOrderItems());
        responseDto.setCreatedAt(product.getCreatedAt());
        responseDto.setUpdatedAt(product.getUpdatedAt());


        return responseDto;
    }
}
