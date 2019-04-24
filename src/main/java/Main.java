import pl.com.britner.util.ReadCSV;
import pl.com.britner.util.ReadFile;

class Main {
    public static void main(String[] args) {

        ReadFile readFile = new ReadCSV();
        System.out.println(readFile.readFile());




/*for (Customer Customer : CustomerRepository.getCustomerList()) {
            CustomerDAO.insertCustomer(Customer);
        }*/

    }
}
