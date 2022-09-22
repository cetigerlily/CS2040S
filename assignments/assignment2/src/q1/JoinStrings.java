package q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class JoinStrings {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in);
        int numOfWords = Integer.parseInt((io.getWord()));
        ArrayList<StringBuilder> words = new ArrayList<>();
        ArrayList<Integer> instructions = new ArrayList<>();

        for(int i = 0; i < numOfWords; i++) {
            String input = io.getWord();
            words.add(new StringBuilder(input));
        }

        for(int j = 0; j < numOfWords - 1; j++) {
            int aString = io.getInt();
            int bString = io.getInt();

            if(!instructions.contains(aString - 1)) {
                instructions.add(aString - 1);
            }
            if(!instructions.contains(bString - 1)) {
                instructions.add(bString -1);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int k = 0; k < instructions.size(); k++) {
            result.append(words.get(instructions.get(k)));
        }

        io.println(result.toString());
        io.flush();
    }
}
