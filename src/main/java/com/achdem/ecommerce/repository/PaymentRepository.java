package com.achdem.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.achdem.ecommerce.entity.Payment;

public interface PaymentRepository extends  JpaRepository<Payment, Long>{
}
