import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;

class Main {
    public static void main(String[] args) {

        Customer c1 = CustomerRepository.getCustomerList().get(0);
        CustomerDAO.insertCustomer(c1);
        c1.addContact(new Contact.contactBuilder()
                .customerId(1L)
                .id(3L)
                .type(1)
                .contact("test@gmail.com")
                .build());
        System.out.println(c1.getContactList().get(0));

        //ContactDAO.insertContact(c1.getContactList().get(0));
    }
}
