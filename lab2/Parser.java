import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Parser {
    
    // Stack that stores all the strings
    private static Stack<String> s = new Stack<>();


    /**
     * POP STACK AND READS IT OFF
     */
    private void printStackContents() {
        while (!s.isEmpty()) {
            String command = s.pop();
            System.out.println(command);
        }
    }

    /**
     * Parses the Strings using () as identifiers and storing them in a stack
     */
    private static void commandParser(String command) {
        int parCounter = 0;

        // Going through it char by char
        String currentCommand = "";
        boolean firstBracket = false;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            currentCommand = currentCommand + c;

            // Checking if it is a valid command after the length is longer than 7 characters
            if (c == '(') {
                parCounter++;
                // whatever we collected before '(' is a command
                currentCommand = currentCommand.substring(0, currentCommand.length() - 1);
                currentCommand = currentCommand.trim();
                s.push(currentCommand);
                currentCommand = "";
            }
            else if (c == ')' && firstBracket == false) {
                firstBracket = true;
                currentCommand = currentCommand.substring(0, currentCommand.length() - 1);
                currentCommand = currentCommand.trim();
                s.push(currentCommand);
                currentCommand = "";
            }
        }
        Parser test = new Parser();
        test.printStackContents();
    }


    /**
     * Reading in the file contents and interpreting them
     */
    public static void commentParser(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            // Going through the command a parsing the shhh
            while (scanner.hasNextLine()) {
                String wordLine = scanner.nextLine();
                Scanner wordScanner = new Scanner(wordLine);

                boolean comment = false;
                String strippedLine = ""; 

                while (wordScanner.hasNext()) {
                    String word = wordScanner.next();
                    if (word.equals("shhh")) {
                        comment = !comment;
                    } 
                    else if (!comment) {
                        strippedLine += word + " ";
                    }
                }
                wordScanner.close();
                System.out.println(strippedLine.trim());
                Parser.commandParser(strippedLine.trim()); // Now going to perform the command if it is valid command
            }
            scanner.close();

        } 
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    private S
    private void commandExecuter() {





    }

    private 

    public static void main(String[] args) {

        Parser.commentParser("example.txt");
        return;
    }

}