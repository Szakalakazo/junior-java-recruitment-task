import pl.com.britner.transfer.FileTypeDeterminer;

import java.io.File;

class Main {
    public static void main(String[] args) {

        File file = new File("E:\\Robocze\\09. JAVA\\09.02 Java Projects\\09.02.07 Various Tutorials\\Britnet\\dane-osoby-kopia.txt");

        FileTypeDeterminer determiner = new FileTypeDeterminer();
        determiner.executeDataTransfer(file);

    }
}
