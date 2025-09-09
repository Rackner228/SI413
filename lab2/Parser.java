import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    
    // Stack that stores all the strings
    private static Stack<String> s = new Stack<>();
    
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
        test.commandExecuter();
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
                // System.out.println(strippedLine.trim());
                Parser.commandParser(strippedLine.trim()); // Now going to perform the command if it is valid command
            }
            scanner.close();

        } 
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    private void commandExecuter() {
        String save = "";
        while (!s.isEmpty()) {
            String command = s.pop();
            Commands commandFunction = new Commands();
            //System.out.println("Original: " + command);

            // Token list
            List<String> tokens = new ArrayList<>();

            // Regex pattern: From Gemini
            Pattern pattern = Pattern.compile("~[A-Z]* [\\s\\S]*? ~[A-Z]*|[^\\s]+");
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                tokens.add(matcher.group());
            }

            // GIVE_ME/UNIFY replacer/cleaner
            tokens = commandCleaner(tokens);

            //Now execute commands (This is done by popping)
            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);   // <-- get token at position i

                if (token.equals("REVERTERE")) {
                    save = commandFunction.REVERTERE(save);
                    // System.out.println("REVERTERE" + save);
                } 
                else if (token.equals("HEAR_YE")) {
                    commandFunction.HERESAY(save);
                } 
                else {
                    // Normal text goes into save
                    save = tildeCleaner(token);
                }
            }
        }
    }
    

    /**
     * Condenses the token into one
     */
    private List<String> commandCleaner(List<String> tokens) {
        Commands command = new Commands();
        // Replacing Tokens of GIVE_ME with a String
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("GIVE_ME")) {
                String input = command.GIVE_ME();
                tokens.set(i, input);
            }
        }

        // Going through the tokens
        for (int i = 0; i < tokens.size(); ) {
            if (tokens.get(i).equals("UNIFY")) {
                if (i == 0 || i == tokens.size() - 1) {
                    System.out.println("UNIFY is being used incorrectly");
                    System.exit(1);
                }

                String combined = command.UNIFY(tokens.get(i - 1), tokens.get(i + 1));

                // Replace left with combined/remove right word/ remove UNIFY
                tokens.set(i - 1, combined);
                tokens.remove(i + 1);
                tokens.remove(i);   
            } 
            else {
                // To allowed chained UNIFY to work
                i++;
            }
        }
        return tokens;
    }   

    /**
     * Checks if ~ should be kept in and if it is a valid string
     */
    private String tildeCleaner(String s) {
        System.out.println("CLEANING:" + s);
        // Not a valid string
        String result = "";
        if (s.length() == 0 || s.charAt(0) != '~') {
            return s;
        }

        // Got this from Gemini to backtrace and use matcher.
        Matcher m1 = Pattern.compile("^~([A-Z]*)(.*?)~\\1$", Pattern.DOTALL).matcher(s);
        if (m1.matches()) {
            return m1.group(2);
        }
        // Got this from Gemini to backtrace and use matcher.
        Matcher m2 = Pattern.compile("^~[A-Z]* (.*?) ~", Pattern.DOTALL).matcher(s);
        if (m2.find()) {
            return m2.group(1);
        }
        System.out.println("CLEAN: " + result);
        return result;
    }

    public static void main(String[] args) {

        //Parser.commentParser("example.txt");
        Parser parser = new Parser();
        String test = parser.tildeCleaner("~HELLO print this out: ~ ~HELLO");
        System.out.println(test);
        parser.commandParser("HEAR_YE(~APPLE I'd like to print a ~ thank you very much. ~APPLE)"); //Something is wrong tildeCleaner now
        //parser.commandParser("HEAR_YE(REVERTERE(~ I am a DRAMATIC LANGUAGE ~)) shhh I NEED MY SPACE! shhh");
        return;
    }

}