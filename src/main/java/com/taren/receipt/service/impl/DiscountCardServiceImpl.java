package com.taren.receipt.service.impl;

import com.taren.receipt.entity.DiscountCard;
import com.taren.receipt.repo.DiscountCardRepository;
import com.taren.receipt.service.IDiscountCardService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCardServiceImpl implements IDiscountCardService {

    @Autowired
    private DiscountCardRepository discountCardRepository;

    @Override
    public DiscountCard getDiscountCardById(Long id) {
        return discountCardRepository.getDiscountCardById(id).orElseThrow(() -> new EntityNotFoundException("it was not found the discount card with id->" + id));
    }
}
