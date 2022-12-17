package com.taren.receipt.service;

import java.io.IOException;
import java.util.List;

public interface IFileService {
    void writeFile(List<String> listToWrite);

    String loadFromFile() throws IOException;
}
