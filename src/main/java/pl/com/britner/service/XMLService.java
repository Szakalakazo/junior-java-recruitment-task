package pl.com.britner.service;

import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.util.XMLReader;

import java.util.List;

public class XMLService {

    private XMLReader reader = new XMLReader();

    public void insertDoDB(List<Customer> customerList) {
        CustomerDAO.insertCustomer(customerList);
    }



}
