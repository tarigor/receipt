package com.taren.receipt.service.impl;

import com.taren.receipt.ReceiptApplication;
import com.taren.receipt.entity.Product;
import com.taren.receipt.repo.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReceiptApplication.class)
@AutoConfigureTestDatabase
@Sql(scripts = "/shop.sql")
class ProductServiceImplTest {


    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void getProductById() {
        Product testProduct = new Product("kefir", 1.4, true);
        Product product = productRepository.save(testProduct);
        System.out.println("stored product -> " + product);

        Product productFromDB = productService.getProductById(1L);
        System.out.println("product from DB -> "+productFromDB);
        Assert.assertEquals(productFromDB, testProduct);
    }

}