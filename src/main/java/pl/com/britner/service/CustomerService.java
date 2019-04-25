package pl.com.britner.service;

import pl.com.britner.util.CSVReaderText;
import pl.com.britner.util.TextFileReader;


public class CustomerService {

    public String[] getDataRows() {
        TextFileReader textFileReader = new CSVReaderText();
        return textFileReader.getTextList().toArray(new String[0]);
    }

    private boolean isFieldValid(String field) {
        return (field == null || field.isEmpty());
    }

    public String replaceNullOrEmptyField(String field) {
        return isFieldValid(field) ?  field = "0": field;
    }
}