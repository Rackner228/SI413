import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Commands {

    /**
     * REVERTERE reversing of a string (Source: https://www.geeksforgeeks.org/java/reverse-a-string-in-java/)
     */
    public static String REVERTERE(String s) {
        if(s == "") {
            return "ERROR: NOTHING TO REVERSE";
        }
        char ch;
        String r = ""; // String that will store the rez`verse
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            r = ch + r; 
        }
        //throw new UnsupportedOperationException("this doesn't work yet");
        return r;
    }

    /**
     * Performs the Concatenation of the Word
     */
    public static String UNIFY(String word1, String word2) {
        String newWord = word1 + word2;
        //throw new UnsupportedOperationException("this doesn't work yet");
        return newWord;
    }

    /**
     *  Displaying the word on the terminal
     */
    public static void HERESAY(String word) {
        //throw new UnsupportedOperationException("this doesn't work yet");
        System.out.println(word);
        Compiler.llvmFile.print(word);
    }

    public static String GIVE_ME() {
        String result = "";
        Scanner sc = new Scanner(System.in);
        result = sc.nextLine();
        //throw new UnsupportedOperationException("this doesn't work yet");
        return result;
    }
}