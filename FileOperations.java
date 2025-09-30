import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperations {

    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Data written successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading file: " + fileName);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile(String fileName, String targetWord, String wordToAdd) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<String> modifiedLines = new ArrayList<>();
            for (String line : lines) {
                // Add "Lalitha " in front of "Anusha"
                modifiedLines.add(line.replace(targetWord, wordToAdd + " " + targetWord));
            }
            Files.write(Paths.get(fileName), modifiedLines);
            System.out
                    .println("File modified successfully: Added '" + wordToAdd + "' in front of '" + targetWord + "'");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "task1.txt";

        writeFile(fileName, "My name is Anusha and this is my 1st task.");
        readFile(fileName);

        modifyFile(fileName, "Anusha", "Lalitha");
        readFile(fileName);
    }
}
