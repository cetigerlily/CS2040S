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
        Kattio io = new Kattio(System.in, System.out);
        int numOfWords = Integer.parseInt((io.getWord()));
        HashMap<Integer, String> words = new HashMap<>(); /* <index of word, word> */
        Instruction[] instructions = new Instruction[numOfWords];
        
        for(int i = 0; i < numOfWords; i++) {
            String input = io.getWord();
            words.put(i, input);
            instructions[i] = new Instruction(i);
        }

        int tracker = 0;
        for(int j = 0; j < numOfWords - 1; j++) {
            int a = io.getInt() - 1;
            int b = io.getInt() - 1;

            instructions[a].setNextInstruction(instructions[b]);
            if(j == numOfWords - 2) {
                tracker = a;
            }
        }

        for(Instruction temp = instructions[tracker]; temp != null; temp = temp.getNextInstruction()) {
            io.print(words.get(temp.getIndex()));
        }

        io.flush();
    }
}
