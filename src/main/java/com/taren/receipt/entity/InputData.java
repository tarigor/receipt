package com.taren.receipt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class InputData {
    private ArrayList<InputItemData> inputItemData = new ArrayList<>();
    private DiscountCard discountCard;

    public InputData() {
    }
}
