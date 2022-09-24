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
        Kattio io = new Kattio(System.in, System.out);
        long numOfOps = io.getLong();

        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();

        int endHeadIndex = 0;
        int endTailIndex = 1;
        int startHeadIndex = 0;
        int startTailIndex = 1;

        for(int i = 0; i < numOfOps; i++) {
            String operation = io.getWord();
            int variable = io.getInt();
            
            if(operation.equals("push_back")) {
                push(end, endTailIndex, variable);
                endTailIndex += 1;
            }
            
            if (operation.equals("push_front")) {
                push(start, startHeadIndex, variable);
                startHeadIndex -= 1;
            }
            
            if(operation.equals("push_middle")) {
                push(start, startTailIndex, variable);
                startTailIndex += 1;
            }
            
            if(start.size() == end.size() + 2) {
                reshuffle(end, start, endHeadIndex, startTailIndex - 1);
                startTailIndex -= 1;
                endHeadIndex -= 1;
            } else if(start.size() + 2 == end.size()) {
                reshuffle(start, end, startTailIndex, endHeadIndex + 1);
                startTailIndex += 1;
                endHeadIndex += 1;
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

    public static void push(HashMap<Integer, Integer> map, int index, int variable) {
        map.put(index, variable);
    }

    public static void reshuffle(HashMap<Integer, Integer> small, HashMap<Integer, Integer> large, int smallIndex, int largeIndex) {
        small.put(smallIndex, large.get(largeIndex));
        large.remove(largeIndex);
    }
}
