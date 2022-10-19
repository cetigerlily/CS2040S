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

            int[] parent = new int[numOfInts + 1];
            ArrayList<Integer>[] set = new ArrayList[numOfInts + 1];

            for(int i = 1; i < numOfInts + 1; i++) {
                parent[i] = i;
                set[i] = new ArrayList<>();
                set[i].add(i);                
            }

            for(int i = 0; i < numOfCommands; i++) { // after m lines, it will be the next test-case if there are more
                int command = io.getInt();
                if(command == 1) { // union
                    int p = io.getInt();
                    int q = io.getInt();

                    if(parent[p] != parent[q]) {
                        int tracker = set[parent[p]].size() - set[parent[q]].size(); // deal with null exception
                        if(tracker > 0) { // p > q
                            set[parent[p]].addAll(set[parent[q]]);
                            for(int j = 1; j < set[parent[q]].size(); j++) { // don't need to do + 1 for size?
                                parent[set[parent[q]].get(j)] = parent[parent[p]];
                            }
                            set[q] = new ArrayList<>(); // clear the list under q since all are under p now

                            /* set.get(p).addAll(set.get(q));
                            for(int j = 1; j < set.get(q).size() + 1; j++) { // for each value in the smaller set
                                parent[set.get(q).get(j)] = parent[p]; // setting each value to be a child of p since added to p's set
                            }
                            set.add(q, new ArrayList<>()); // now it's a null list at q since q is under p now */

                        } else { // p =< q
                            set[parent[q]].addAll(set[parent[p]]);
                            for(int j = 1; j < set[parent[p]].size(); j++) { // don't need to do + 1 for size?
                                parent[set[parent[p]].get(j)] = parent[parent[q]];
                            }
                            set[p] = new ArrayList<>(); // clear the list under q since all are under p now
                            
                            /* set.get(q).addAll(set.get(p));
                            for(int j = 1; j < set.get(p).size() + 1; j++) { 
                                parent[set.get(p).get(j)] = parent[p]; 
                            }
                            set.add(p, new ArrayList<>()); */
                        }
                    }

                } /* else if(command == 2) { // move p into q's set
                    int p = io.getInt();
                    int q = io.getInt();

                    // handle case where q is a child of p actually don't need 

                    if(parent[p] != parent[q]) {
                        int parentOfQ = parent[q];
                        set.get(parentOfQ).add(p);
                        if((parent[p] == p) && (set.get(p).size() > 1)) { // if p was a root and has elements under it
                            // find the next element in in the arraylist of p
                            int newParent = set.get(p).get(2); // the 2nd element

                            for(int j = 2; j < set.get(p).size() + 1; j++) {
                                parent[set.get(p).get(j)] = newParent;
                            }
                            // make a new ArrayList under the new parent element
                        }
                        parent[p] = parentOfQ;
                        set.get(p).remove(p);
                    }
                } else if(command == 3) {
                    long p = io.getLong();
                } */
            }
            for(int i = 0; i < parent.length; i++) {
                io.println("index: " + i + " value: " + parent[i]);
            }
            io.flush();
        }
    }
