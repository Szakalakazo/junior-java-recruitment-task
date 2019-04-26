package pl.com.britner.repository;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.service.CSVContactService;
import pl.com.britner.service.CSVCustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    private Customer tempCustomer;

    private List<Customer> customerList = new ArrayList<>();

    private CSVContactService CSVContactService = new CSVContactService();

    private CSVCustomerService CSVCustomerService = new CSVCustomerService();

    private String[] dataRows = CSVCustomerService.getDataRows();

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
                .age(Integer.valueOf(CSVCustomerService.replaceNullOrEmptyField(customerDetails[2])))
                .city(customerDetails[3])
                .buildCustomer();
    }

    private void createContact(String[] contacts) {
        for (String contact : contacts) {
            Contact tempContact = new Contact.contactBuilder()
                    .contact(contact)
                    .type(CSVContactService.getContactType(contact))
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
        if (CSVCustomerService.isFieldValid(customer.getName()) && CSVCustomerService.isFieldValid(customer.getSurname()))
            customerList.add(customer);
    }
}
