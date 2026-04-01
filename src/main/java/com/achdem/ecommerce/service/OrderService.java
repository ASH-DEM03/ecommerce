package com.achdem.ecommerce.service;

import com.achdem.ecommerce.entity.Order;
import com.achdem.ecommerce.exception.ResourceNotFoundException;
import com.achdem.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order updateStatus(Long id, String status) {
        Order order = getById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order update(Long id, Order updated) {
        Order order = getById(id);
        order.setStatus(updated.getStatus());
        order.setTotalPrice(updated.getTotalPrice());
        order.setUser(updated.getUser());
        order.setAddress(updated.getAddress());
        order.setCoupon(updated.getCoupon());
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}