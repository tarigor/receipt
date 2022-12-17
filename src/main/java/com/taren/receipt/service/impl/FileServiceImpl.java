package com.taren.receipt.service.impl;

import com.taren.receipt.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl implements IFileService {
    public static final String PATHNAME = "src/main/resources/input_data.txt";
    private final String PATH = "src/main/resources/receipt.txt";

    @Override
    public void writeFile(List<String> receiptToWrite) {
        try {
            FileWriter myWriter = new FileWriter(PATH);
            for (String string : receiptToWrite) {
                myWriter.write(string);
                myWriter.write("\r\n");
            }
            myWriter.close();
            log.info("Successfully wrote to the file.");
        } catch (IOException e) {
            log.error("An error occurred.");
        }
    }

    @Override
    public String loadFromFile() throws IOException {
        return Files.readString(Path.of(PATHNAME));
    }
}
