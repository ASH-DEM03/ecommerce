package com.achdem.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CartDTO {
    private Long id;
    private LocalDateTime createdAt;
    private Long userId;
    private List<CartItemDTO> items;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<CartItemDTO> getItems() { return items; }
    public void setItems(List<CartItemDTO> items) { this.items = items; }

    // nested CartItemDTO inside CartDTO
    public static class CartItemDTO {
        private Long id;
        private Integer quantity;
        private Long productId;
        private String productName;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public Long getProductId() { return productId; }
        public void setProductId(Long productId) { this.productId = productId; }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
    }
}