package pl.com.britner.ui;

import pl.com.britner.transfer.FileTypeDeterminer;

import javax.swing.*;
import java.io.File;

public class FileSelector {

    private static File selectedFile;

    private static final FileTypeDeterminer determiner = new FileTypeDeterminer();

    public static void selectFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
        }
        run();
    }

    private static void run() {
        try {
            System.out.println("Starting data transfer...");
            determiner.executeDataTransfer(selectedFile);
        } catch (NullPointerException e) {
            System.out.println("No file selected. Terminating...");
        }
    }
}