import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

private List<String> list = newArrayList<>();

public class language {
    private static void parser(String fileName) {
        boolean flag = false;
        String store = "";
        try {
            FileReader reader = new FileReader(fileName);
            // Read character by character
            int charCode;
            while ((charCode = reader.read()) != -1) {
                //System.out.print((char) charCode);
                
                char character = (char)charCode;
                // Inside the string literal

                if (character == '"') {
                    if (flag) { 
                        System.out.println(store);
                        list.add(store);
                        store = "";
                        flag = false;
                    } else 
                    {
                        flag = true;
                    }
                } else if (flag) {
                    store = store + character;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) {
    
    
    // Getting in the file name
    System.out.println("Input your file name: ");
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();
    System.out.println("File you inputted: " + fileName + "\n");

    // Calling the parser
    parser(fileName);


    return;
  }
}
