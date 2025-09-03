import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

// Creating a stack that will store commands so that we know what commands to execute
private List<String> list = newArrayList<>();

public class Interp {

    // REVERTERE reversing of a string (Source: https://www.geeksforgeeks.org/java/reverse-a-string-in-java/)
    private String REVERTERE(String s) {
        char ch;
        String r = ""; // String that will store the rez`verse
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            r = ch + r; 
        }
        return r;
    }

    // Concatenation of the Word
    private String UNIFY(String word1, String word2) {
        String newWord = word1 + word2;
        return newWord;
    }

    // Displaying the word on the terminal
    private void HERESAY(String word) {
        System.out.println(word);
    }
private void parser(String fileName) {
    boolean inShhhBlock = false; // persists across lines
    int counter = 1;

    try (Scanner fileScanner = new Scanner(new File(fileName));
         PrintWriter writer = new PrintWriter("stripped.txt")) {

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            // Tokenize line and split parentheses
            List<String> rawTokens = new ArrayList<>();
            try (Scanner wordScanner = new Scanner(line)) {
                while (wordScanner.hasNext()) {
                    splitParens(wordScanner.next(), rawTokens);
                }
            }

            // Strip shhh blocks
            StringBuilder cleaned = new StringBuilder();
            for (String t : rawTokens) {
                if (!inShhhBlock) {
                    if ("shhh".equals(t)) {
                        inShhhBlock = true; // enter comment block
                    } else {
                        if (cleaned.length() > 0) cleaned.append(' ');
                        cleaned.append(t);
                    }
                } else {
                    if ("shhh".equals(t)) {
                        inShhhBlock = false; // exit comment block
                    }
                }
            }

            // Print numbered cleaned line and also write to file
            if (cleaned.length() > 0) {
                String output = String.format("%4d | %s", counter++, cleaned.toString());
                System.out.println(output);
                writer.println(output);
            }
        }

        if (inShhhBlock) {
            System.err.println("Warning: file ended while inside a 'shhh' comment block.");
        }

        System.out.println("Stripped output written to stripped.txt");

    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + fileName);
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
    
        // Getting in the file name
        System.out.println("Input your file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        System.out.println("File you inputted: " + fileName);
        
        // Testing the created functions
        Interp test = new Interp();
        test.parser(fileName);


        return;
  }
}
