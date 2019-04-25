package pl.com.britner.service;

import pl.com.britner.util.CSVReader;
import pl.com.britner.util.FileReader;

public class CSVCustomerService {

    // TODO: 25.04.2019 wybór miedzy csv a txt
    public String[] getDataRows() {
        FileReader fileReader = new CSVReader();
        return fileReader.getTextList().toArray(new String[0]);
    }

    public boolean isFieldValid(String field) {
        return !(field == null || field.isEmpty());
    }

    public String replaceNullOrEmptyField(String field) {
        return isFieldValid(field) ? field : "0";
    }
}