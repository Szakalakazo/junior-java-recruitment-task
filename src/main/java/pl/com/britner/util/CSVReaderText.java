package pl.com.britner.util;

import java.io.*;
import java.util.List;

public class CSVReaderText extends TextFileReader {

    @Override
    public void readFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(super.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                super.stringList.add(line);
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTextList() {
        return stringList;
    }
}
