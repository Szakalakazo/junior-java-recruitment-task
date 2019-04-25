import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.service.CustomerService;
import pl.com.britner.util.CSVReader;
import pl.com.britner.util.FileReader;

import java.util.List;

class Main {
    public static void main(String[] args) {

        FileReader fileReader = new CSVReader();
        CustomerService customerService = new CustomerService();
        customerService.fillCustomerList();
;




/*for (Customer Customer : CustomerRepository.getCustomerList()) {
            CustomerDAO.insertCustomer(Customer);
        }*/

    }
}
