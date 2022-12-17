package com.taren.receipt.service.impl;

import com.taren.receipt.entity.Product;
import com.taren.receipt.repo.ProductRepository;
import com.taren.receipt.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id).orElseThrow(() -> new EntityNotFoundException("it was not found the product with id->" + id));
    }
}
