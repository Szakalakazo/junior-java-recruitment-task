import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;
import pl.com.britner.util.CSVReaderText;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepository();
        for (Customer c : repository.getCustomerList()) {
            System.out.println(c.getName());
            System.out.println(c.getSurname());
            System.out.println(c.getAge());
            System.out.println(c.getCity());
            for (Object arg : c.getContactList()) {
                
                System.out.println(arg);
            }
            System.out.println();

        }

    }
}
