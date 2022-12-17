package com.taren.receipt.service.impl;

import com.taren.receipt.entity.InputData;
import com.taren.receipt.entity.InputItemData;
import com.taren.receipt.service.IConsoleOutputService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Service
public class ConsoleOutputServiceImpl implements IConsoleOutputService {
    public static final double TAX = 0.17;
    public static final String RECEIPT_PROPERTIES = "receipt";
    double totalPrice = 0f;
    double totalPriceFinal = 0f;

    public ArrayList<String> printOutReceipt(InputData inputData) {
        ArrayList<String> output = new ArrayList<>();
        output.addAll(getLinesFromProperties(0, 3));
        //print line with date
        output.add(getLineWithSingleParameter(4, getCurrentDate()));
        //print line with time
        output.add(getLineWithSingleParameter(5, getCurrentTime()));
        output.addAll(getLinesFromProperties(6, 2));
        output.addAll(getLinesWithProductList(inputData, 8, 9, 10));
        output.add(getLineFromProperties(11));
        //taxable tot line
        output.add(getLineWithSingleParameter(12, totalPrice));
        output.add(getLineWithSingleParameter(13, totalPrice * TAX));
        output.add(getLineWithSingleParameter(14, totalPrice + totalPrice * TAX));
        //line - total with discount card
        if (inputData.getDiscountCard() != null) getLineWithTwoParameters(
                15,
                inputData.getDiscountCard().getId(),
                inputData.getDiscountCard().getDiscount(),
                totalPriceFinal - (totalPrice + totalPrice * TAX) * inputData.getDiscountCard().getDiscount() / 100);
        output.forEach(System.out::println);
        return output;
    }

    private ArrayList<String> getLinesWithProductList(InputData inputData, int startLine, int discountLine, int priceAndAmountLine) {
        ArrayList<String> output = new ArrayList<>();
        for (InputItemData inputItemData : inputData.getInputItemData()) {
            double productPrice = inputItemData.getProduct().getPrice();
            String part1 = getLineWithTwoParameters(startLine, inputItemData.getProductAmount(), inputItemData.getProduct().getProductName());
            if (inputItemData.getProductAmount() >= 5) {
                String part2 = getLineFromProperties(discountLine);
                part1 = part1 + part2;
                productPrice = productPrice - productPrice * 0.1f;
            }
            StringBuilder spaces = new StringBuilder();
            //for align the columns
            spaces.append(" ".repeat(Math.max(0, 36 - part1.length())));
            output.add(part1 + spaces + getLineWithTwoParameters(priceAndAmountLine, productPrice, productPrice * inputItemData.getProductAmount()));
            totalPrice = totalPrice + productPrice * inputItemData.getProductAmount();
        }
        return output;
    }

    private String getLineWithSingleParameter(int lineNumber, Object parameter) {
        return getLineFromProperties(lineNumber).formatted(parameter);
    }

    private String getLineWithTwoParameters(int lineNumber, Object parameter1, Object parameter2) {
        return getLineFromProperties(lineNumber).formatted(parameter1, parameter2);
    }

    private String getLineWithTwoParameters(int lineNumber, Object parameter1, Object parameter2, Object parameter3) {
        return getLineFromProperties(lineNumber).formatted(parameter1, parameter2, parameter3);
    }

    private String getCurrentDate() {
        return DateTimeFormatter
                .ofPattern("yyyy/MM/dd")
                .format(LocalDateTime.now());
    }

    private String getCurrentTime() {
        return DateTimeFormatter
                .ofPattern("HH:mm:ss")
                .format(LocalDateTime.now());
    }

    private String getLineFromProperties(int lineNumber) {
        return ResourceBundle.getBundle(RECEIPT_PROPERTIES).getString("st" + lineNumber);
    }

    private ArrayList<String> getLinesFromProperties(int from, int count) {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = from; i < from + count; i++) {
            lines.add(getLineFromProperties(i));
        }
        return lines;
    }
}
