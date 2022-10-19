package q1;
import java.util.*;

public class AlmostUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            int numOfInts = io.getInt();
            int numOfCommands = io.getInt();

            HashMap<Integer, Integer> parent = new HashMap<>(); // <int, parent>
            HashMap<Integer, ArrayList<Integer>> set = new HashMap<>(); // <int, set that belongs to int>

            for(int i = 1; i < numOfInts + 1; i++) {
                parent.put(i, i);
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
                        if(tracker >= 0) { // p > q, add q to p
                            set.get(parentP).addAll(set.get(parentQ)); // add set under parent of q to the set under parent of p
                            for(int element : set.get(parentQ)) {
                                parent.put(element, parentP);
                            }
                            set.put(q, new ArrayList<>());
                        } else {
                            set.get(parentQ).addAll(set.get(parentP)); // add set under parent of q to the set under parent of p
                            for(int element : set.get(parentP)) {
                                parent.put(element, parentQ);
                            }
                            set.put(p, new ArrayList<>());
                        }
                    }

                } else if(command == 2) { // move
                    int p = io.getInt();
                    int q = io.getInt();

                    int parentP = parent.get(p);
                    int parentQ = parent.get(q);

                    if(parentP != parentQ) {
                        set.get(parentQ).add(p);
                        parent.put(p, parentQ);
                        set.get(parentP).remove(set.get(parentP).indexOf(p));
                    }
                } else if(command == 3) { // numAndSum
                    int p = io.getInt();
                    int parentP = parent.get(p);

                    long numOfElements = set.get(parentP).size();
                    long sumOfElements = 0;

                    for(int element : set.get(parentP)) {
                        sumOfElements += element;
                    }

                    io.println(numOfElements + " " + sumOfElements);
                }
            }
            io.flush();
        }
    }
}
