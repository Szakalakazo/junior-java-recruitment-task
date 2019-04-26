package pl.com.britner.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends FileReader {

    private List<String> strings = new ArrayList<>();

    @Override
    void readFile(File file) {
        String line;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            while ((line = br.readLine()) != null)
                if (line.length() > 0) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTextList(File file) {
        readFile(file);
        return strings;
    }
}