package q1;
import java.util.*;

public class AlmostUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            int numOfInts = io.getInt();
            int numOfCommands = io.getInt();

            HashMap<Integer, Integer> parent = new HashMap<>(); // <int, parent>
            ArrayList<Integer>[] set = new ArrayList[numOfInts + 1];
            // HashMap<Integer, ArrayList<Integer>> set = new HashMap<>(); // <int, set that belongs to int>

            for(int i = 1; i < numOfInts + 1; i++) {
                io.println("Value: " + i + " Parent: " + parent.get(i));
            }

            for(int i = 1; i < numOfInts + 1; i++) {
                parent.put(i, i);
                set[i] = new ArrayList<>();
                set[i].add(i);
            }

            for(int i = 0; i < numOfCommands; i++) { // after m lines, it will be the next test-case if there are more
                int command = io.getInt();
                if(command == 1) {
                    int p = io.getInt();
                    int q = io.getInt();

                    if(parent.get(p) != parent.get(q)) {
                        long tracker = set[parent.get(p)].size() - set[parent.get(q)].size();
                        if(tracker >= 0) { // p > q, add q to p
                            set[parent.get(p)].addAll(set[parent.get(q)]); // add set under parent of q to the set under parent of p
                            for(int element : set[parent.get(q)]) {
                                parent.put(element, parent.get(p));
                            }
                            set[q] = new ArrayList<>();
                        } else {
                            set[parent.get(q)].addAll(set[parent.get(p)]); // add set under parent of q to the set under parent of p
                            for(int element : set[parent.get(p)]) {
                                parent.put(element, parent.get(q));
                            }
                            set[p] = new ArrayList<>();
                        }
                    }

                } else if(command == 2) { // move
                    int p = io.getInt();
                    int q = io.getInt();
                    if(parent.get(p) != parent.get(q)) {
                        set[parent.get(q)].add(p);
                        parent.put(p, parent.get(q));
                        set[parent.get(p)].remove(set[parent.get(p)].indexOf(p));
                    }
                } else if(command == 3) { // numAndSum
                    int p = io.getInt();

                    long numOfElements = set[parent.get(p)].size();
                    long sumOfElements = 0;

                    for(int element : set[parent.get(p)]) {
                        sumOfElements += element;
                    }
                    System.out.println(numOfElements + " " + sumOfElements);
                }
            }

            for(int i = 1; i < numOfInts + 1; i++) {
                System.out.println("Value: " + i + " New Parent: " + parent.get(i));
            }
            
        }
        io.flush();
    }
}
