package com.pichincha.msastore.repository;

import com.pichincha.msastore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
