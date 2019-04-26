package pl.com.britner.util;


import pl.com.britner.config.FileProperties;
import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader {

    File file = new File(FileProperties.getXMLFilePath());

    final String filePath = FileProperties.getCSVFilePath();

    List<Contact> contactList = null;

    List<Customer> customerList = null;

    private List<String> stringList = new ArrayList<>();

    abstract void readFile();

    public List<String> getTextList() {
        return stringList;
    }
}
