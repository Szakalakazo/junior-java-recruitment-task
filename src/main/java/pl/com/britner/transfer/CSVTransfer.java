package pl.com.britner.transfer;

import pl.com.britner.service.CSVService;

import java.io.File;

public class CSVTransfer implements Transfer {


    public void loadToDB(File file) {
        CSVService service = new CSVService();
        service.start(file);
    }
}
