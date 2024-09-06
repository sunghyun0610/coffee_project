package com.grepp.coffee_project.domain.product.repository;

import com.grepp.coffee_project.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,byte[]> {
}
