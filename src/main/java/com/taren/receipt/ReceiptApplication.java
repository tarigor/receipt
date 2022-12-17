package com.taren.receipt;

import com.taren.receipt.entity.InputData;
import com.taren.receipt.service.IFileService;
import com.taren.receipt.service.IInputDataHandlerService;
import com.taren.receipt.service.impl.ConsoleOutputServiceImpl;
import com.taren.receipt.service.impl.FileServiceImpl;
import com.taren.receipt.service.impl.InputDataHandlerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class ReceiptApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = SpringApplication.run(ReceiptApplication.class, args);

        IInputDataHandlerService iInputDataHandlerService = ctx.getBean(InputDataHandlerServiceImpl.class);
        ConsoleOutputServiceImpl consoleOutputService = ctx.getBean(ConsoleOutputServiceImpl.class);
        IFileService fileService = ctx.getBean(FileServiceImpl.class);


        // InputData inputData = iInputDataHandlerService.loadInputData(args);
        InputData inputData = iInputDataHandlerService.loadInputData(fileService.loadFromFile().split(" "));


        ArrayList<String> receiptLinesList = consoleOutputService.printOutReceipt(inputData);
        fileService.writeFile(receiptLinesList);

    }

}
