import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;

class Main {
    public static void main(String[] args) {

        Customer c1 = CustomerRepository.getCustomerList().get(0);
//        CustomerDAO.insertCustomer(c1);
        System.out.println(c1.getName());
        System.out.println(c1.getSurname());
        System.out.println(c1.getAge());
        System.out.println(c1.getCity());
        Contact c = c1.getContactList().get(0);
        System.out.println(c.getType());
        System.out.println(c.getContact());

    }
}
