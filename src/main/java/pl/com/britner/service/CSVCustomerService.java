package pl.com.britner.service;

import pl.com.britner.util.CSVReader;

import java.io.File;

public class CSVCustomerService  {

    public String[] getDataRows(File file) {
        CSVReader fileReader = new CSVReader();
        return fileReader.getTextList(file).toArray(new String[0]);
    }

    public boolean isFieldValid(String field) {
        return !(field == null || field.isEmpty());
    }

    public String replaceNullOrEmptyField(String field) {
        return isFieldValid(field) ? field : "0";
    }
}
