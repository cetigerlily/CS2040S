import java.util.*;

// UFDS data structure
public class VirtualFriends {
    public static String findSet(HashMap<String, String> parents, String s) {
        if(parents.get(s).equals(s)) {
            return s;
        } else {
            return findSet(parents, parents.get(s));
        }
    }

    public static void unionSet(HashMap<String, String> parents, String i, String j) {
        String parentI = findSet(parents, i);
        String parentJ = findSet(parents, j);

        parents.put(parentI, parentJ);
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            HashMap<String, String> parent  = new HashMap<>(); // tracking if in a set
            HashMap<String, Integer> children = new HashMap<>(); // size of sets <parent, # of children>
            
            int numOfFriendships = io.getInt();
            for(int j = 0; j < numOfFriendships; j++) {
                String friendA = io.getWord();
                String friendB = io.getWord();

                int numInNetwork = 0;

                if(!parent.containsKey(friendA) && !parent.containsKey(friendB)) { // both aren't in any set yet because they don't have a parent
                    // make a new set
                    children.put(friendA, 2);

                    parent.put(friendB, friendA);
                    parent.put(friendA, friendA);

                    numInNetwork += children.get(friendA);

                } else if(parent.containsKey(friendA) && !parent.containsKey(friendB)) { // A is alr in a set but B isn't
                    // add B to A's parent
                    String parentA = findSet(parent, friendA);
                    parent.put(friendB, parentA);

                    children.put(parentA, children.get(parentA) + 1);
                    numInNetwork += children.get(parentA);

                } else if(!parent.containsKey(friendA) && parent.containsKey(friendB)) {
                    // add A to B's parent
                    String parentB = findSet(parent, friendB);
                    parent.put(friendA, parentB);

                    children.put(parentB, children.get(parentB) + 1);
                    numInNetwork += children.get(parentB);

                } else if(parent.containsKey(friendA) && parent.containsKey(friendB)) { // both are already in sets
                    String parentA = findSet(parent, friendA);
                    String parentB = findSet(parent, friendB);
                    
                    if(parentA.equals(parentB)) { // in same set, do nothing
                        numInNetwork += children.get(parentA);
                    } else { // in different sets - union them
                        unionSet(parent, friendA, friendB);
                        children.put(parentA, children.get(parentA) + children.get(parentB));
                        numInNetwork += children.get(parentA);
                    }
                }
                io.println(numInNetwork);
            }
        }
        io.flush();
        io.close();
    }
}
