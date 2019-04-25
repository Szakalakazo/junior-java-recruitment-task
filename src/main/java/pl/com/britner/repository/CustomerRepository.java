package pl.com.britner.repository;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.service.ContactService;
import pl.com.britner.service.CustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    private CustomerService customerService = new CustomerService();

    private ContactService contactService = new ContactService();

    private List<Customer> customerList = new ArrayList<>();

    private Customer tempCustomer;

    private Contact tempContact;

    private String[] dataRows = customerService.getDataRows();


    private void fillCustomerList() {
        for (String dataRow : dataRows) {
            String[] customerDetails = Arrays.copyOfRange(dataRow.split(","), 0, 4);
            String[] customerContacts = Arrays.copyOfRange(dataRow.split(","), 4, (dataRow.split(",")).length);

            createCustomer(customerDetails);
            createContact(customerContacts);
            addCustomer(tempCustomer);
        }
    }

    private void createCustomer(String[] customerDetails) {
        tempCustomer = new Customer.customerBuilder()
                .name(customerDetails[0])
                .surname(customerDetails[1])
                .age(Integer.valueOf(customerService.replaceNullOrEmptyField(customerDetails[2])))
                .city(customerDetails[3])
                .buildCustomer();
    }

    private void createContact(String[] contacts) {
        for (String contact : contacts) {
            tempContact = new Contact.contactBuilder()
                    .contact(contact)
                    .type(contactService.getContactType(contact))
                    .buildContact();
            tempCustomer.addToContactList(tempContact);

        }
    }

    public List<Customer> getCustomerList() {
        if (customerList.isEmpty()) {
            fillCustomerList();
        }
        return customerList;
    }

    private void addCustomer(Customer customer) {
        if (customerService.isFieldValid(customer.getName()) && customerService.isFieldValid(customer.getSurname()))
            customerList.add(customer);
    }
}