package pl.com.britner.service;

import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;

import java.io.File;
import java.util.List;

public class CSVService {

    private List<Customer> customerList;

    public void start(File file) {
        CustomerRepository repository = new CustomerRepository();
        repository.setFile(file);
        customerList = repository.getCustomerList();
        insertDoDB();
    }

    private void insertDoDB() {
        CustomerDAO.insertCustomer(customerList);
    }
}
