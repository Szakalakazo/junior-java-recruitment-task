package pl.com.britner.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLReader extends FileReader {

    private List<String> strings = new ArrayList<>();
    private StringBuilder line = new StringBuilder();

    @Override
    public void readFile() {
        String[] components = {"name", "surname", "age", "city"};

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(this.file);

            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            int i = 0;
            while (i < nodeList.getLength()) {
                Node node = nodeList.item(i);
                isNodeEmpty(components, node);
                i++;
            }
            System.out.println(line);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
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
    }
}