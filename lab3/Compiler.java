import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;

public class Compiler {

    public static ll llvmFile;

    // Creating a stack that will store commands so that we know what commands to execute
    private Stack<String> s = new Stack<>();
    public static void main(String[] args) {
    
        // Getting in the file name
        if (args.length !=2) {
            System.out.println("java Compiler .txt   .ll\n");
            return;
        }

        String fileName = args[0];
        
        // Running the Interp
        Parser.commentParser(fileName); 

        // Checking for 2nd arg and creating the file
        if(args[1] != null) {
            llvmFile = new ll(args[1]);
        }
        return;
    }
}

