package com.taren.receipt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InputItemData {
    private Product product;
    private int productAmount;
}
