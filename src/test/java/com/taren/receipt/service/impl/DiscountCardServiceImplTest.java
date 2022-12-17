package com.taren.receipt.service.impl;

import com.taren.receipt.ReceiptApplication;
import com.taren.receipt.entity.DiscountCard;
import com.taren.receipt.repo.DiscountCardRepository;
import com.taren.receipt.service.IDiscountCardService;
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
class DiscountCardServiceImplTest {

    @Autowired
    IDiscountCardService discountCardService;

    @Autowired
    DiscountCardRepository discountCardRepository;

    @Test
    void getDiscountCardById() {
        DiscountCard discountCard = new DiscountCard(1L,14);
        DiscountCard discountCardStored = discountCardRepository.save(discountCard);
        System.out.println("discount card stored -> " + discountCardStored);

        DiscountCard discountCardFromDB = discountCardService.getDiscountCardById(1L);
        System.out.println("discount card from DB -> " + discountCardFromDB);
        Assert.assertEquals(discountCardStored, discountCardFromDB);
    }
}