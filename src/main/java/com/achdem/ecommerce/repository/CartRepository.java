package com.achdem.ecommerce.repository;

import com.achdem.ecommerce.entity.Brand;
import com.achdem.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
