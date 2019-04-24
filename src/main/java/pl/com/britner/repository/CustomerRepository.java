package pl.com.britner.repository;

import pl.com.britner.model.Contact;
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
                .contactList(new Contact.contactBuilder()
                        .type(1)
                        .contact("555-555")
                        .buildContact())
                .buildCustomer());

        customerList.add(new Customer.customerBuilder()
                .name("Sue")
                .surname("Fox")
                .age(26)
                .city("Los Santos")
                .buildCustomer());
    }
}