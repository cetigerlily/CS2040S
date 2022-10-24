package q1;
import java.util.*;

public class AlmostUnionFind {
    static Kattio io = new Kattio(System.in, System.out);
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, ArrayList<Integer>> set;
    // HashMap<Integer, Integer> size;
    // HashMap<Integer, Long> sum;

    public AlmostUnionFind(int numOfInts) {
        this.parent = new HashMap<>();
        this.set = new HashMap<>();
        
        for(int i = 1; i < numOfInts + 1; i++) {
            this.parent.put(i, i);
            this.set.put(i, new ArrayList<>());
            this.set.get(i).add(i);
            System.out.println("c" + this.set.get(i).toString());

        }
        System.out.println("c" + this.parent.toString());
    }

    public int parentOf(int i) {
        return parent.get(i);
    }

    public ArrayList<Integer> setOf(int i) {
        return set.get(i);
    }

    public void union(int p, int q) {
        System.out.println("a" + setOf(parentOf(p)).toString());
        System.out.println("a" + setOf(parentOf(q)).toString());

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


        System.out.println("a" + setOf(parentOf(p)).toString());
        System.out.println("a" + setOf(parentOf(q)).toString());
    }

    public void move(int p, int q) {
        System.out.println("b" + setOf(parentOf(p)).toString());
        System.out.println("b" + setOf(parentOf(q)).toString());

        if(parentOf(p) != parentOf(q)) {
            setOf(parentOf(p)).remove((Object) p);  
            setOf(parentOf(q)).add(p);
            System.out.println("d" + setOf(parentOf(q)).toString());
            parent.put(p, parentOf(q));
        }

        System.out.println(parentOf(p) + " " + p);

        System.out.println("b" + setOf(p).toString());
        System.out.println("b" + setOf(q).toString());
    }

    public void numAndSum(int p) {
        System.out.println(setOf(parentOf(p)).toString());
        int numOfElements = setOf(parentOf(p)).size();
        long sumOfElements = 0;

        for(int element : setOf(parentOf(p))) {
            sumOfElements += element;
        }
        System.out.println(numOfElements + " " + sumOfElements);
    }

    public static void main(String[] args) {
        while(io.hasMoreTokens()) {
            int numOfInts = io.getInt();
            int numOfCommands = io.getInt();
            AlmostUnionFind testCase = new AlmostUnionFind(numOfInts);

            for(int i = 1; i < numOfInts + 1; i++) {
                System.out.println("Value: " + i + " Parent: " + testCase.parentOf(i));
            }

            for(int i = 0; i < numOfCommands; i++) {
                int command = io.getInt();
                if(command == 1) {
                    int p = io.getInt();
                    int q = io.getInt();
                    testCase.union(p, q);
                    for(int j = 1; j < numOfInts + 1; j++) {
                        System.out.println("Value: " + j + " New Parent: " + testCase.parentOf(j));
                    }
                } else if(command == 2) {
                    int p = io.getInt();
                    int q = io.getInt();
                    testCase.move(p, q);
                    for(int j = 1; j < numOfInts + 1; j++) {
                        System.out.println("Value: " + j + " New Parent: " + testCase.parentOf(j));
                    }
                } else if(command == 3) {
                    int p = io.getInt();
                    testCase.numAndSum(p);
                    for(int j = 1; j < numOfInts + 1; j++) {
                        System.out.println("Value: " + j + " New Parent: " + testCase.parentOf(j));
                    }
                }
            }
        }

        io.flush();
    }
}
