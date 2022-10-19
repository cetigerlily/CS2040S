package q1;

import java.util.*;

/** PSEUDO-CODE:
 * 1) Have an array which holds not only the root of the set it belongs to, but keeps track of how many elements, sum of elements
 * 2) Have an ArrayList for the set of elements
 */

public class AlmostUnionFind {
    public void union(long p, long q) {
    }

    public void move(long p, long q) {

    }

    public void numAndSum(long p) {

    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            long numOfInts = io.getLong();
            long numOfCommands = io.getLong();
            int[] parents; // an array which is 1-indexed and parent[i] refers to the parents of i
            ArrayList<Integer>[] sets; // array of collections of the elements in a set

            for(int i = 1; i < numOfInts + 1; i++) {
                parents[i] = i;
                sets[i] = new ArrayList<>();
                sets[i].add(i);
            }

            for(int i = 0; i < numOfCommands; i++) { // after m lines, it will be the next test-case
                long command = io.getLong();
                if(command == 1) { // union
                    long p = io.getLong();
                    long q = io.getLong();
                    union(p, q);

                } else if(command == 2) { // move

                } else if(command == 3) {

                }
            }
        }
    }
}
