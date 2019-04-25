package pl.com.britner.util;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import pl.com.britner.model.Customer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLReader extends FileReader {

    private StringBuilder line = new StringBuilder();
    private String[] components = {"name", "surname", "age", "city", "phone", "email", "jabber"};
    List<Customer> customerList = null;
    Customer tempCustomer = null;
    String text = null;


    @Override
    public void readFile() {
        try {

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(this.file));

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT: {
                        if ("person".equals(reader.getLocalName())) {
                            tempCustomer = new Customer();
                        }
                        if ("person".equals(reader.getLocalName()))
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
                        }
                        break;
                    }
                }

            }
            for (Customer customer : customerList) {
                System.out.println(customer.getName());
                System.out.println(customer.getSurname());
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }


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

















