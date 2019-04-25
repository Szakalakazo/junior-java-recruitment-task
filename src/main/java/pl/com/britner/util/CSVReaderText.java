package pl.com.britner.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderText extends TextFileReader {

    private List<String> strings = new ArrayList<>();

    @Override
    public void readFile() {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(super.filePath))) {
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTextList() {
        readFile();
        return strings;
    }
}