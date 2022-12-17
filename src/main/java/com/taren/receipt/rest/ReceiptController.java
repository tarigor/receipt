package com.taren.receipt.rest;

import com.taren.receipt.entity.InputData;
import com.taren.receipt.entity.InputItemData;
import com.taren.receipt.service.IDiscountCardService;
import com.taren.receipt.service.impl.ConsoleOutputServiceImpl;
import com.taren.receipt.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ReceiptController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private IDiscountCardService discountCardService;
    @Autowired
    private ConsoleOutputServiceImpl consoleOutputService;

    @GetMapping("/check")
    @ResponseBody
    public ArrayList<String> getReceipt(
            @RequestParam(name = "itemId") Long itemId,
            @RequestParam(name = "itemAmount") int itemAmount,
            @RequestParam(name = "discountCardId") Long discountCardId) {

        ArrayList<InputItemData> inputItemData = new ArrayList<>();
        inputItemData.add(new InputItemData(productService.getProductById(itemId), itemAmount));
        return consoleOutputService.printOutReceipt(new InputData(inputItemData, discountCardService.getDiscountCardById(discountCardId)));
    }
}
