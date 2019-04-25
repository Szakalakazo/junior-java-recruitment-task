package pl.com.britner.util;


import pl.com.britner.config.FileProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader {

    final String filePath = FileProperties.getCSVFilePath();

    File file = new File(FileProperties.getXMLFilePath());

    private List<String> stringList = new ArrayList<>();

    abstract void readFile();

    public List<String> getTextList() {
        return stringList;
    }
}
