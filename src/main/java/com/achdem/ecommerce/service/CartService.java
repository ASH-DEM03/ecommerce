package com.achdem.ecommerce.service;

import com.achdem.ecommerce.entity.Cart;
import com.achdem.ecommerce.entity.CartItem;
import com.achdem.ecommerce.exception.ResourceNotFoundException;
import com.achdem.ecommerce.repository.CartRepository;
import com.achdem.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart getById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    public CartItem addItem(CartItem cartItem) {
        // make sure the cart exists
        getById(cartItem.getCart().getId());
        return cartItemRepository.save(cartItem);
    }

    public void removeItem(Long cartItemId) {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new ResourceNotFoundException("CartItem not found");
        }
        cartItemRepository.deleteById(cartItemId);
    }

    public void delete(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cart not found");
        }
        cartRepository.deleteById(id);
    }
}