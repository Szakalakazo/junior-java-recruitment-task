package pl.com.britner.util;


import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader {

    List<Contact> contactList = null;

    List<Customer> customerList = null;

    private List<String> stringList = new ArrayList<>();

    abstract void readFile(File file);

}
