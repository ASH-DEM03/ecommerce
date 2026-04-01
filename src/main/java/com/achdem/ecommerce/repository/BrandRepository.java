package com.achdem.ecommerce.repository;

import com.achdem.ecommerce.entity.Brand;
import com.achdem.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
