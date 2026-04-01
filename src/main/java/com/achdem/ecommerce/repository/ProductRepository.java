package com.achdem.ecommerce.repository;

import com.achdem.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Nothing needed here — JpaRepository provides all required methods
}