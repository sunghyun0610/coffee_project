package com.grepp.coffee_project.domain.product.service;

import com.grepp.coffee_project.domain.product.dto.CreateCoffeeDto;
import com.grepp.coffee_project.domain.product.dto.DetailCoffeeDto;
import com.grepp.coffee_project.domain.product.dto.ReadCoffeeDto;
import com.grepp.coffee_project.domain.product.dto.ResponseDto;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;



    public List<ReadCoffeeDto> getAllCoffee(){
        List<ReadCoffeeDto> readCoffeeDtoList=new ArrayList<>();
        List<Product> productList =productRepository.findAll();  //findAll== SELECT * FROM products;
        for(Product product: productList){
            ReadCoffeeDto readCoffeeDto= new ReadCoffeeDto();
            readCoffeeDto.setImage("이미지는 아직 테스트중");
            readCoffeeDto.setProductId(product.getProduct_id());
            readCoffeeDto.setProductName(product.getProduct_name());
            readCoffeeDtoList.add(readCoffeeDto);
        }
        return readCoffeeDtoList;
    }

    public DetailCoffeeDto getOneCoffee(long id){
        Optional<Product> coffee =productRepository.findById(id);//조회
        DetailCoffeeDto detailCoffeeDto=new DetailCoffeeDto();
        detailCoffeeDto.setImage("이미지는 아직 준비중이라고");
        detailCoffeeDto.setProductName(coffee.get().getProduct_name());
        detailCoffeeDto.setDescription(coffee.get().getDescription());
        detailCoffeeDto.setPrice(coffee.get().getPrice());
        detailCoffeeDto.setProductId(coffee.get().getProduct_id());
        detailCoffeeDto.setCategory(coffee.get().getCategory());
        return detailCoffeeDto;
    }
    // 첫 번째 get()은 Optional에서 Product를 가져오는 것이고, 두 번째 getCategory()는 Product 객체의 필드 값을 가져오는 메서드입니다.

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
