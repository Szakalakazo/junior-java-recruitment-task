package pl.com.britner.util;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader extends FileReader {

    private Customer tempCustomer = null;
    private String text = null;


    @Override
    public void readFile() {
        try {

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(this.file));

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

    public List<Customer> getCustomerList() {
        if(customerList == null)
            readFile();
        return customerList;
    }





































    /*@Override
    public void readFile() {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(this.file);

            NodeList nodeList = doc.getElementsByTagName("person");
            int num = nodeList.getLength();

            for (int i = 0; i < num; i++) {
                Element node = (Element) nodeList.item(i);
                listAllAttributes(node);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllAttributes(Element element) {
        System.out.println("List attributes for nodes: " + element);

        NamedNodeMap attributes = element.getAttributes();

        int numAttrs = attributes.getLength();

        for (int i = 0; i < numAttrs; i++) {
            Attr item = (Attr) attributes.item(i);

            String attrName = item.getNodeName();
            String attrValue = item.getNodeValue();

            System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
        }
    }

    private boolean doesNodeMatch(String[] components, Node node) {
        for (String component : components) {
            String stringNode = node.
                    toString().
                    replaceAll("[\\[\\]:]", "").
                    replaceAll("\\ null\\b", "");

            if (stringNode.equals(component)) {
                *//*Element element = (Element) node;
                String textContent =
                        element.getElementsByTagName(component).item(0).getTextContent();
                line.append(textContent).append(",");*//*
                return true;
            }
        }
        return false;
    }

    private void isNodeEmpty(String[] components, Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            Arrays.stream(components).forEachOrdered(component -> {
                Node item = element.getElementsByTagName(component).item(0);
                if (item != null) {
                    String textContent = element.getElementsByTagName(component).item(0).getTextContent();
                    line.append(textContent).append(",");
                }
            });
            line.append("\n");
        }
    }*/
}

















