package pl.com.britner.util;


import pl.com.britner.config.FileProperties;

import java.util.ArrayList;
import java.util.List;

public abstract class TextFileReader {

    final String filePath = FileProperties.getFilePath();

    List<String> stringList = new ArrayList<>();

    abstract void readFile();

    public List<String> getTextList() {
        return stringList;
    }
}
