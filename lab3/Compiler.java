import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Compiler {
    // Creating a stack that will store commands so that we know what commands to execute
    private Stack<String> s = new Stack<>();
    public static void main(String[] args) {
    
        // Getting in the file name
        if (args.length < 1) {
            System.out.println("Need file");
            return;
        }

        String fileName = args[0];
        
        // Testing the created functions
        Parser.commentParser(fileName); 
        return;
    }
}
