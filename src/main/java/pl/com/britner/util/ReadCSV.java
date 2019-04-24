package pl.com.britner.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV implements ReadFile {

    @Override
    public List<String> readFile() {

        List<String> stringList = new ArrayList<>();

        String filePath = "E:\\Robocze\\09. JAVA\\09.02 Java Projects\\09.02.07 Various Tutorials\\Britnet\\test.txt";

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line  = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
