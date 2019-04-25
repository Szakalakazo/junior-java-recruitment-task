import pl.com.britner.dao.CustomerDAO;
import pl.com.britner.model.Customer;
import pl.com.britner.repository.CustomerRepository;
import pl.com.britner.service.XMLService;
import pl.com.britner.util.XMLReader;


class Main {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepository();


//        CustomerDAO.insertCustomer(repository.getCustomerList());

/*        XMLReader xmlReader = new XMLReader();
        xmlReader.readFile();*/
        XMLService service = new XMLService();
        XMLReader reader = new XMLReader();
        service.insertDoDB(reader.getCustomerList());
    }
}
