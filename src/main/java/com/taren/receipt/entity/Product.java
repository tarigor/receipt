package com.taren.receipt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double price;
    private boolean isAuctionItem;

    public Product(String productName, double price, boolean isAuctionItem) {
        this.productName = productName;
        this.price = price;
        this.isAuctionItem = isAuctionItem;
    }
}
