package com.ashish.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashish.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}