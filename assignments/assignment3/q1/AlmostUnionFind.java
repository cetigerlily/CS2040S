package q1;
import java.util.*;

public class AlmostUnionFind {
    static Kattio io = new Kattio(System.in, System.out);
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, ArrayList<Integer>> set;

    public AlmostUnionFind(int numOfInts) {
        this.parent = new HashMap<>();
        this.set = new HashMap<>();
        
        for(int i = 1; i < numOfInts + 1; i++) {
            this.parent.put(i, i);
            this.set.put(i, new ArrayList<>());
            this.set.get(i).add(i);
        }
    }

    public int parentOf(int i) {
        return parent.get(i);
    }

    public ArrayList<Integer> setOf(int i) {
        return set.get(i);
    }

    public void union(int p, int q) {
        if(parentOf(p) != parentOf(q)) {
            int tracker = setOf(parentOf(p)).size() - setOf(parentOf(q)).size();
            if(tracker >= 0) { // p > q, add q to p
                setOf(parentOf(p)).addAll(setOf(parentOf(q))); // add set under parent of q to the set under parent of p
                for(int element : setOf(parentOf(q))) {
                    parent.put(element, parentOf(p));
                }
                set.put(q, new ArrayList<>());
            } else {
                setOf(parentOf(q)).addAll(setOf(parentOf(p))); // add set under parent of q to the set under parent of p
                for(int element : setOf(parentOf(p))) {
                    parent.put(element, parentOf(q));
                }
                set.put(p, new ArrayList<>());
            }
        }
    }

    public void move(int p, int q) {
        if(parentOf(p) != parentOf(q)) {
            setOf(parentOf(p)).remove((Object) p);  
            setOf(parentOf(q)).add(p);
            parent.put(p, parentOf(q));
        }
    }

    public void numAndSum(int p) {
        int numOfElements = setOf(parentOf(p)).size();
        long sumOfElements = 0;

        for(int element : setOf(parentOf(p))) {
            sumOfElements += element;
        }
        io.println(numOfElements + " " + sumOfElements);
    }

    public static void main(String[] args) {
        while(io.hasMoreTokens()) {
            int numOfInts = io.getInt();
            int numOfCommands = io.getInt();
            AlmostUnionFind testCase = new AlmostUnionFind(numOfInts);

            for(int i = 0; i < numOfCommands; i++) {
                int command = io.getInt();
                if(command == 1) {
                    int p = io.getInt();
                    int q = io.getInt();
                    testCase.union(p, q);
                } else if(command == 2) {
                    int p = io.getInt();
                    int q = io.getInt();
                    testCase.move(p, q);
                } else if(command == 3) {
                    int p = io.getInt();
                    testCase.numAndSum(p);
                }
            }
        }
        io.flush();
    }
}
