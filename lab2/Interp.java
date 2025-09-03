import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interp {
    // Creating a stack that will store commands so that we know what commands to execute
    private final List<String> commands = new ArrayList<>();
    private String storedVariable = "";

    // Making a stack commands
    private void push(String cmd) {
        commands.add(cmd); // push onto stack
    }

    private String pop() {
        if (commands.isEmpty()) {
            return null;
        }
        return commands.remove(commands.size() - 1);
    }

    /**
     * Returns true if stack is not empty
     */
    private boolean emptyCheck() {
        if (commands.isEmpty()) {
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * REVERTERE reversing of a string (Source: https://www.geeksforgeeks.org/java/reverse-a-string-in-java/)
     */
    private String REVERTERE(String s) {
        if(s == "") {
            return "ERROR";
        }
        char ch;
        String r = ""; // String that will store the rez`verse
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            r = ch + r; 
        }
        return r;
    }

    /**
     * Performs the Concatenation of the Word
     */
    private String UNIFY(String word1, String word2) {
        String newWord = word1 + word2;
        return newWord;
    }

    /**
     *  Displaying the word on the terminal
     */
    private void HERESAY(String word) {
        System.out.println(word);
    }

    /**
     * Reading in the file contents and interpreting them
     */
    private void commentParser(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

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
                commandParser(strippedLine.trim()); // Now going to perform the command if it is valid command
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Parses lines of word and carries out the command
     */
    private void commandParser(String command) {
        int parCounter = 0;
        //command = "HEAR_YE(REVERTERE(REVERTERE(GIVE_ME)))"; // Test variable for now
        // Going into the inner most () and then performing that command
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
                push(currentCommand);
                currentCommand = "";
            }
            else if (c == ')' && firstBracket == false) {
                firstBracket = true;
                currentCommand = currentCommand.substring(0, currentCommand.length() - 1);
                currentCommand = currentCommand.trim();
                push(currentCommand);
                currentCommand = "";
                commandStackExecuter();
            }
        }
    }

    /**
     * executes the commands in the stack
     */
    private void commandStackExecuter() {
        String unifyString = ""; 
        String unifyString2 = "";
        String result = "";

        while (emptyCheck()) {
            String current = pop();
            String[] tokens = current.split("\\s+");

            for (int i = 0; i < tokens.length; i++) {
                String tok = tokens[i];
                if (tok.equals("UNIFY")) {
                    // take the last result as first piece
                    unifyString = result;

                    // grabing the next token
                    if (i + 1 < tokens.length) {
                        String nextTok = tokens[i++];
                        if (nextTok.equals("GIVE_ME")) {
                            Scanner sc = new Scanner(System.in);
                            unifyString2 = sc.nextLine();
                        } else {
                            unifyString2 = nextTok;
                        }
                    }
                    result = UNIFY(unifyString, unifyString2);
                }
                else if (tok.equals("GIVE_ME")) {
                    Scanner sc = new Scanner(System.in);
                    result = sc.nextLine();
                } 
                else if (tok.equals("REVERTERE")) {
                    result = REVERTERE(result);
                } 
                else if (tok.equals("HEAR_YE")) {
                    HERESAY(result);
                } 
                else {
                    result = tok;
                }
            }

            //System.out.println("COMMAND STACK: " + tokens[0]);
            //System.out.println("FINAL: " + result);
        }

        storedVariable = "";
    }

    /**
     * Excutes the command with the given arguments (SCAPPED DUE TO UNIFY)
     */
    private void commandExecute(String command, String unify, String unify2) {
        switch (command) {
            case "HEAR_YE":
                HERESAY(storedVariable);
                break;
            case "REVERTERE":
                storedVariable = REVERTERE(storedVariable);
                break;
            case "UNIFY":
                break;
            case "GIVE_ME":
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                storedVariable = input;
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }

    public static void main(String[] args) {
    
        // Getting in the file name
        if (args.length < 1) {
            System.out.println("Need file");
            return;
        }

        String fileName = args[0];
        System.out.println(fileName);
        
        // Testing the created functions
        Interp test = new Interp();
        test.commentParser(fileName);
        return;
    }
}
