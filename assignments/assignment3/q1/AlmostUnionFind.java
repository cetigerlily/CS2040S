package q1;

import java.util.*;

/** PSEUDO-CODE:
 * 1) Have an array which holds not only the root of the set it belongs to, but keeps track of how many elements, sum of elements
 * 2) Have an ArrayList for the set of elements
 */

public class AlmostUnionFind {
    int[] parents; // an array which is 1-indexed and parent[i] refers to the parents of i
    ArrayList<Integer> sets = new ArrayList<>(); // collection of the elements in a set

    // could also do a hashmap where <root, set> ?

    public void union(long p, long q) {
    }

    public void move(long p, long q) {

    }

    public void numAndSum(long p) {

    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        long numOfInts = io.getLong();
        long numOfCommands = io.getLong();


        for(int i = 0; i < numOfCommands; i++) {
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
