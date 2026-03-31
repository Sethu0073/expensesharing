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

// Handle Field Comparison based on type
Fields.forEach((String key, String value) -> {

    // TEXT TYPE
    if(type.equals("Text")) {
        if(!(key.equalsIgnoreCase("Cross match element") ||
             key.equalsIgnoreCase("Text Equivalent") ||
             key.equalsIgnoreCase("Ignore case") ||
             key.equalsIgnoreCase("Ignore character") ||
             key.equalsIgnoreCase("Tolerate textual difference"))) {
            return; // 🔥 skip invalid ones
        }
    }

    // NUMBER TYPE
    else if(type.equals("Integer") || type.equals("Decimal")) {
        if(!(key.equalsIgnoreCase("Numeric tolerance") ||
             key.equalsIgnoreCase("Percentage tolerance") ||
             key.equalsIgnoreCase("Compare absolute value") ||
             key.equalsIgnoreCase("Cross match element"))) {
            return;
        }
    }

    // DATE TYPE
    else if(type.equals("Date") || type.equals("Date/Time")) {
        if(!(key.equalsIgnoreCase("Date tolerance") ||
             key.equalsIgnoreCase("Ignore day portion") ||
             key.equalsIgnoreCase("Cross match element"))) {
            return;
        }
    }

    // ✅ Only valid elements reach here
    checkPageElementPresent(value, key);
});
