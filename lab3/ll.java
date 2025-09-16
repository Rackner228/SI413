import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;


/**
 * These are ways for me to write easier onto the .ll file
 */
public class ll {

    private String ll_filename;


    // Constructor
    public ll(String file) {
        ll_filename = file;
        // Creating the file: Source(https://www.w3schools.com/java/java_files_create.asp)
        try {
            File myObj = new File(ll_filename); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } 
            else {
                // Cleaning the file if it does exist
                FileWriter fw = new FileWriter(ll_filename, false);
                fw.close();
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
        // Now writing to the file for basic format
        try {
            FileWriter fWriter = new FileWriter(ll_filename, true);

            // The basic text
            String text = "target triple = \"x86_64-pc-linux-gnu\"\n\n" +
            "declare i32 @puts(ptr noundef) #1\n\n" +
            "define i32 @main() {\n" + "  call i32 @puts(ptr @lit1)\n";

            // Writing into file
            fWriter.write(text);
            fWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred in writing to the .ll");
            e.printStackTrace(); // Print error details
        }
    }

    public void print(String word) {
        try (FileWriter fWriter = new FileWriter(ll_filename, true)) {
            // length includes null terminator
            int length = word.length() + 1;

            // unique label for each literal (so multiple prints work)
            String label = "@lit" + System.currentTimeMillis(); // or use a counter

            // string constant
            String text = label + " = constant [" + length + " x i8] c\"" + word + "\\00\"\n";

            // write the constant
            fWriter.write(text);
            fWriter.write("  call i32 @puts(ptr " + label + ")\n");

        } 
        catch (IOException e) {
            System.out.println("An error occurred in writing to the .ll");
            e.printStackTrace();
        }
    }

    public void close() {
        try (FileWriter fWriter = new FileWriter(ll_filename, true)) {
            fWriter.write("  ret i32 0\n}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}