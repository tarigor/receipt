package com.taren.receipt.service;

import com.taren.receipt.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Product getProductById(Long id);
}
