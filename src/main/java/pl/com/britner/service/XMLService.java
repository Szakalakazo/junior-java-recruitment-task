package pl.com.britner.service;

import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.util.XMLReader;

import java.io.File;
import java.util.List;

public class XMLService {

    private List<Customer> customerList;

    public void start(File file) {
        XMLReader reader = new XMLReader();
        customerList = reader.getCustomerList(file);
        insertDoDB();
    }

    private void insertDoDB() {
        CustomerDAO.insertCustomer(customerList);
    }
}
