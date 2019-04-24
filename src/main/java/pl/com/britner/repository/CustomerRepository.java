package pl.com.britner.repository;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        if (customerList.isEmpty()) {
            fillCustomerList();
        }
        return customerList;
    }

    public void addCustomer(Customer customer)  {
        customerList.add(customer);
    }

    private void fillCustomerList() {
        customerList.add(new Customer.customerBuilder()
                .name("Bob")
                .surname("Brink")
                .city("NY")
                .contactList(new Contact.contactBuilder()
                        .type(1)
                        .contact("bobBrink")
                        .buildContact())
                .buildCustomer());

        customerList.add(new Customer.customerBuilder()
                .name("Sue")
                .surname("Fox")
                .age(26)
                .city("Los Santos")
                .contactList(new Contact.contactBuilder()
                        .type(1)
                        .contact("SueFOX.com.pl")
                        .buildContact())
                .contactList(new Contact.contactBuilder()
                        .type(1)
                        .contact("666-999-888")
                        .buildContact())
                .buildCustomer());

        customerList.add(new Customer.customerBuilder()
                .name("Arya")
                .surname("Stark")
                .age(16)
                .city("Winterloo")
                .contactList(new Contact.contactBuilder()
                        .type(3)
                        .contact("arya@stark.com.pl")
                        .buildContact())
                .buildCustomer());

        customerList.add(new Customer.customerBuilder()
                .id(3L)
                .contactList(new Contact.contactBuilder()
                        .contact("555-555")
                        .buildContact())
                .buildCustomer());
    }
}