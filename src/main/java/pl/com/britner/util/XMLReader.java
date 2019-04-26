package pl.com.britner.util;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader extends FileReader {

    private Customer tempCustomer = null;
    private String text = null;


    @Override
    public void readFile(File file) {
        try {

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));

            fillCustomer(reader);

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void fillCustomer(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();

            Contact tempContact;
            switch (event) {
                case XMLStreamConstants.START_ELEMENT: {
                    if ("person".equals(reader.getLocalName())) {
                        tempCustomer = new Customer();
                        contactList = new ArrayList<>();
                        tempCustomer.setContactList(contactList);
                    }
                    if ("persons".equals(reader.getLocalName()))
                        customerList = new ArrayList<>();

                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    text = reader.getText().trim();
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    switch (reader.getLocalName()) {
                        case "person": {
                            customerList.add(tempCustomer);
                            break;
                        }
                        case "name": {
                            tempCustomer.setName(text);
                            break;
                        }
                        case "surname": {
                            tempCustomer.setSurname(text);
                            break;
                        }
                        case "age": {
                            tempCustomer.setAge(Integer.parseInt(text));
                            break;
                        }
                        case "city": {
                            tempCustomer.setCity(text);
                            break;
                        }
                        case "email": {
                            tempContact = new Contact();
                            tempContact.setType(1);
                            tempContact.setContact(text);
                            contactList.add(tempContact);
                            break;
                        }
                        case "phone": {
                            tempContact = new Contact();
                            tempContact.setType(2);
                            tempContact.setContact(text);
                            contactList.add(tempContact);
                            break;
                        }
                        case "jabber": {
                            tempContact = new Contact();
                            tempContact.setType(3);
                            tempContact.setContact(text);
                            contactList.add(tempContact);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    public List<Customer> getCustomerList(File file) {
        if(customerList == null)
            readFile(file);
        return customerList;
    }
}