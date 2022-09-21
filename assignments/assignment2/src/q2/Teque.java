package q2;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Teque {
    public static void main(String[] args) {
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>(); // <key, value> = <index, value>

        int endHeadIndex = -1;
        int endTailIndex = 0;
        int startHeadIndex = -1;

        Kattio io = new Kattio(System.in, System.out);
        long numOfOps = io.getLong();

        for(int i = 0; i < numOfOps; i++) {
            String operation = io.getWord();
            int variable = io.getInt();
            
            if(operation.equals("push_back")) {
                pushBack(end, endTailIndex++, variable);
            }
            
            if (operation.equals("push_front")) {
                pushFront(start, startHeadIndex--, variable);
            }
            
            if (operation.equals("push_middle")) {
                if(start.size() > end.size()) {
                    pushFront(end, endTailIndex, variable);
                } else {
                    pushBack(start, startHeadIndex, variable);
                }
            }

            if(operation.equals("get")) {
                if(variable < start.size()) {
                    io.println(start.get(startHeadIndex + variable + 1));
                } else {
                    io.println(end.get(endHeadIndex + (variable - start.size()) + 1));
                }
            }
        }

        io.flush();
    }
    
    public static void pushBack(HashMap<Integer, Integer> map, int index, int variable) {
        map.put(index, variable);
    }

    public static void pushFront(HashMap<Integer, Integer> map, int index, int variable) {
        map.put(index, variable);
    }
}
