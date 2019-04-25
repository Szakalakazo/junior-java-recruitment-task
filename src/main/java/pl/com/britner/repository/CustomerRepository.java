package pl.com.britner.repository;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.service.CustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    private CustomerService service = new CustomerService();

    private List<Customer> customerList = new ArrayList<>();

    private void createCustomerList() {
        String[] dataRows = service.getDataRows();
        for (String row : dataRows) {
            String[] split = Arrays.copyOfRange(row.split(","), 0, 4);

            Customer tempCustomer = new Customer.customerBuilder()
                    .name(split[0])
                    .surname(split[1])
                    .age(Integer.valueOf(service.replaceNullOrEmptyField(split[2])))
                    .buildCustomer();
            customerList.add(tempCustomer);
        }
    }


    public List<Customer> getCustomerList() {
        if (customerList.isEmpty()) {
            createCustomerList();
        }
        return customerList;
    }

    public void addCustomer(Customer customer) {
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