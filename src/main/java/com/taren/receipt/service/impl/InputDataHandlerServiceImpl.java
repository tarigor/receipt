package com.taren.receipt.service.impl;

import com.taren.receipt.entity.InputData;
import com.taren.receipt.entity.InputItemData;
import com.taren.receipt.service.IInputDataHandlerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InputDataHandlerServiceImpl implements IInputDataHandlerService {

    private InputData inputData;

    @Autowired
    private DiscountCardServiceImpl discountCardService;

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public InputData loadInputData(String[] inputDataArray) {
        InputData inputData = new InputData();
        for (String data : inputDataArray) {
            if (data.contains("card")) {
                Long discountCardId = Long.parseLong(data.split("-")[1]);
                try {
                    inputData.setDiscountCard(discountCardService.getDiscountCardById(discountCardId));
                } catch (EntityNotFoundException e) {
                    log.error("the discount card with id->" + discountCardId + " it was not found");
                }
            } else {
                Long productId = Long.parseLong(data.split("-")[0]);
                try {
                    inputData.getInputItemData().add(new InputItemData(productService.getProductById(productId), Integer.parseInt(data.split("-")[1])));
                } catch (EntityNotFoundException e) {
                    log.error("the product with id->" + productId + " it was not found");
                }
            }
        }
        log.info("input data: " + inputData);
        this.inputData = inputData;
        return this.inputData;
    }

    public InputData getInputData() {
        return inputData;
    }
}
