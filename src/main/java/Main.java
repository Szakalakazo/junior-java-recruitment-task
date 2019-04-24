import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;

class Main {
    public static void main(String[] args) {

        Customer c1 = CustomerRepository.getCustomerList().get(0);
        Customer c2 = CustomerRepository.getCustomerList().get(1);
        System.out.println(c1.getId());
        System.out.println(c1.getName());
        System.out.println(c1.getSurname());
        System.out.println(c1.getAge());
        System.out.println(c1.getCity());
        Contact con1 = c1.getContactList().get(0);
        System.out.println("Contact type: " + con1.getType());
        System.out.println(con1.getContact());

        System.out.println(c2.getId());
        System.out.println(c2.getName());
        System.out.println(c2.getSurname());
        System.out.println(c2.getAge());
        System.out.println(c2.getCity());
        /*Contact con2 = c2.getContactList().get(0);
        System.out.println(con2.getType());
        System.out.println(con2.getContact());*/
        for (Customer Customer : CustomerRepository.getCustomerList()) {

            CustomerDAO.insertCustomer(Customer);
        }

    }
}
