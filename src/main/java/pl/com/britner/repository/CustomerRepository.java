package pl.com.britner.repository;

import pl.com.britner.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private static final List<Customer> customerList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        if (customerList.isEmpty()) {
            fillCustomerList();
        }
        return customerList;
    }

    private static void fillCustomerList() {
        customerList.add(new Customer.customerBuilder()
                .name("Bob")
                .surname("Brink")
                .age(22)
                .city("NY")
                .build());

        customerList.add(new Customer.customerBuilder()
                .name("Sue")
                .surname("Fox")
                .age(26)
                .city("Los Santos")
                .build());
    }
}