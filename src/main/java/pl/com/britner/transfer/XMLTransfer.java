package pl.com.britner.transfer;

import pl.com.britner.service.XMLService;

import java.io.File;

public class XMLTransfer implements Transfer {


    public void loadToDB(File file) {
        XMLService service = new XMLService();
        service.start(file);
    }
}
