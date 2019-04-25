package pl.com.britner.service;

import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;
import pl.com.britner.util.CSVReader;
import pl.com.britner.util.FileReader;

import java.util.Arrays;


public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

    public void fillCustomerList() {
        FileReader fileReader = new CSVReader();

        // rzutowanie list wierszy na tablice wierszy
        String[] dataRows = fileReader.readFile().toArray(new String[0]);

        for (String row : dataRows) {
            String[] split = row.split(",");
            String[] customerDetails = Arrays.copyOfRange(split, 0, 4);
            String[] contactDetails = Arrays.copyOfRange(split, 4, split.length);
            System.out.println(Arrays.toString(customerDetails));
            System.out.println(Arrays.toString(contactDetails));


        }
    }
}
