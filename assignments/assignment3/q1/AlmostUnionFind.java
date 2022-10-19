package q1;

import java.util.*;

/** PSEUDO-CODE:
 * 1) Array pointing to parents of i element eg. parents[i] = the parent of value i, if parent[i] == i, i is the root
 * 2) ArrayList containing the elements in a set - only roots/parents will have a non-null ArrayList
 * 
 * union:
 * 1) Check if p and q are in the same set - in the same set if parents[p] == parents[q]
 * 2) If not in same set, find which set is smaller, add smaller to larger
 * 3) For each value in the smaller set, set it's parent to the set it's been added to
 * 4) Clear smaller set by init new ArrayList 
 *
 * move:
 * 1) Check if p is already in q's set or not - in the same set if parents[p] == parents[q]
 * 2) Find the parent of q - add p into the set stored at the parent of q
 * 3) Set p's new parent to parent of q
 * 4) If p was a root, then you have to change the parent of all it's children
 * 5) Remove p from the set is was in before
 * 
 * numAndSum:
 */

public class AlmostUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // while(io.hasMoreTokens()) { // check if this is going to work or not
            int numOfInts = io.getInt();
            int numOfCommands = io.getInt();

            HashMap<Integer, Integer> parent = new HashMap<>(); // <int, parent>
            HashMap<Integer, ArrayList<Integer>> set = new HashMap<>(); // <int, set that belongs to int>

            for(int i = 1; i < numOfInts + 1; i++) {
                parent.put(i, i); // initially, everything is it's own parent
                set.put(i, new ArrayList<>());
                set.get(i).add(i);    
            }

            for(int i = 0; i < numOfCommands; i++) { // after m lines, it will be the next test-case if there are more
                int command = io.getInt();
                if(command == 1) {
                    int p = io.getInt();
                    int q = io.getInt();
                    
                    int parentP = parent.get(p);
                    int parentQ = parent.get(q);

                    if(parentP != parentQ) {
                        int tracker = set.get(parentP).size() - set.get(parentQ).size(); // size of set under parent of p - size of set under parent of q
                        if(tracker > 0) { // p > q, add q to p
                            set.get(parentP).addAll(set.get(parentQ)); // add set under parent of q to the set under parent of p
                            for(int j = 1; j < set.get(parentQ).size() + 1; j++) { // for each value in the set under parent of q, change it's parent to the parent of p
                                parent.put(set.get(parentQ).get(j), parentP); // update the parent of the elem under parent of Q to be the parent of P
                            }
                            set.put(q, new ArrayList<>());
                        } else {
                            set.get(parentQ).addAll(set.get(parentP));
                            for(int j = 1; j < set.get(parentP).size() + 1; j++) {
                                parent.put(set.get(parentP).get(j), parentQ); // update the parent of the elem under parent of Q to be the parent of P
                            }
                            set.put(p, new ArrayList<>());
                        }
                    }
                }
            }

            // debugging
/*  HashMap<Integer, Integer> parent = new HashMap<>(); // <int, parent>
            HashMap<Integer, ArrayList<Integer>> set = new HashMap<>(); // <int, set that belongs to int> */

            for(int i = 1; i < numOfInts + 1; i++) {
                int parentOfI = parent.get(i);
                io.println("The parent of " + i + " is " + parentOfI);
            }
            io.flush();
        }
    }
