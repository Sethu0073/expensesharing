package util;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void saveToFile(String data) {

        try {

            FileWriter writer = new FileWriter("expense_log.txt", true);

            writer.write(data + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Unable to save data to file.");

        }
    }
}
