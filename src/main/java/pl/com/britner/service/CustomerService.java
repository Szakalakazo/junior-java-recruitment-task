package pl.com.britner.service;

import pl.com.britner.repository.CustomerRepository;
import pl.com.britner.util.CSVReaderText;
import pl.com.britner.util.TextFileReader;


public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

    public void fillCustomerList() {
        TextFileReader textFileReader = new CSVReaderText();

        // rzutowanie list wierszy na tablice wierszy
        //String[] dataRows = textFileReader.readFile().toArray(new String[0]);

        /*for (String row : dataRows) {
            String[] split = row.split(",");
            String[] customerDetails = Arrays.copyOfRange(split, 0, 4);
            String[] contactDetails = Arrays.copyOfRange(split, 4, split.length);

        }*/
    }
}
