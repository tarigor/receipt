package com.taren.receipt.service;

import com.taren.receipt.entity.InputData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IConsoleOutputService {
    ArrayList<String> printOutReceipt(InputData inputData);
}
