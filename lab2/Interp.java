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
        String r = ""; // String that will store the reverse
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

    // Reading in the file contents and interpreting them
    private void parser(String fileName) {
        // Reading the file
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Getting the word
            int counter = 1;
            while (scanner.hasNextLine()) {
                System.out.print(counter++);
                String wordLine = scanner.nextLine();
                Scanner wordScanner = new Scanner(wordLine);
                
                // If it is a comment
                while(wordScanner.hasNext()) {
                    String word = wordScanner.next();
                    if(word.equals("shhh")) {
                        // We are going to keep cycling until it is not a shhh
                        while(wordScanner.hasNext() && !wordScanner.next().equals("shhh")) {}
                    }
                }
                System.out.println(wordLine);
            }
            scanner.close();

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
        /*
        System.out.println(test.UNIFY("hello ", "World"));
        test.HERESAY(test.REVERTERE("hello World"));
        */
       test.parser(fileName);


        return;
  }
}
