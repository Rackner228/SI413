import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;

public class Compiler {
    // Creating a stack that will store commands so that we know what commands to execute
    private Stack<String> s = new Stack<>();
    public static void main(String[] args) {
    
        // Getting in the file name
        if (args.length !=2) {
            System.out.println("java Compiler .txt  .ll\n");
            return;
        }

        String fileName = args[0];
        
        // Running the Interp
        Parser.commentParser(fileName); 

        // Checking for 2nd arg and creating the file
        if(args[1] != null) {
            String ll_filename = args[1];
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
                FileWriter fWriter = new FileWriter(ll_filename);

                // The basic text
                String text = "target triple = \"x86_64-pc-linux-gnu\"\n\n" +
                "declare i32 @puts(ptr noundef) #1\n\n" +
                "define i32 @main() {\n" + "  call i32 @puts(ptr @lit1)\n  ret i32 0\n}";

                // Writing into file
                fWriter.write(text);
                fWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred in writing to the .ll");
                e.printStackTrace(); // Print error details
            }
        }
        return;
    }
}

