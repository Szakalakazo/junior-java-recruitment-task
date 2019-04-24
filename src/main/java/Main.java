import pl.com.britner.dao.UserDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;

public class Main {
    public static void main(String[] args) {

        Customer c1 = CustomerRepository.getCustomerList().get(0);
        UserDAO userDAO = new UserDAO();
        userDAO.insertCustomer(c1);
    }
}
