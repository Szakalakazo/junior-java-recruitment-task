package pl.com.britner.transfer;

import java.io.File;

public class FileTypeDeterminer {

    private static String determineFileType(File file) {
        String path = file.getAbsolutePath();
        int i = path.lastIndexOf('.');
        return path.substring(i + 1);
    }

    public void executeDataTransfer(File file) {
        if (!file.exists()) {
            System.out.println("FILE DOES NOT EXIST.");
        }
        if (determineFileType(file).equalsIgnoreCase("csv") || determineFileType(file).equalsIgnoreCase("txt")) {
            Transfer transfer = new CSVTransfer();
            transfer.loadToDB(file);
        } else if (determineFileType(file).equalsIgnoreCase("xml")) {
            Transfer transfer = new XMLTransfer();
            transfer.loadToDB(file);
        } else System.out.println("Cannot recognize file type!");
    }
}