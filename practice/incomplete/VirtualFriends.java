import java.util.*;

// UFDS data structure
public class VirtualFriends {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            HashMap<String, String> parent  = new HashMap<>(); // tracking if in a set
            HashMap<String, Integer> children = new HashMap<>(); // size of sets
            
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
                    String parentFriend = friendA;
                    while(!parent.get(parentFriend).equals(parentFriend)) {
                        parentFriend = parent.get(parentFriend);
                    }

                    parent.put(friendA, parentFriend); // update parent
                    parent.put(friendB, parentFriend);

                    children.put(parentFriend, children.get(parentFriend) + 1);
                    numInNetwork += children.get(parentFriend);

                } else if(!parent.containsKey(friendA) && parent.containsKey(friendB)) {
                    // add A to B's parent
                    String parentFriend = friendB;
                    while(!parent.get(parentFriend).equals(parentFriend)) {
                        parentFriend = parent.get(parentFriend);
                    }

                    parent.put(friendB, parentFriend); // update parent
                    parent.put(friendA, parentFriend);

                    children.put(parentFriend, children.get(parentFriend) + 1);
                    numInNetwork += children.get(parentFriend);

                } else if(parent.containsKey(friendA) && parent.containsKey(friendB)) { // both are already in sets
                    if(parent.get(friendA).equals(parent.get(friendB))) { // in same set, do nothing
                        numInNetwork += children.get(parent.get(friendA));
                    } else { // in different sets - union them
                        String parentA = friendA;
                        while(!parent.get(parentA).equals(parentA)) {
                            parentA = parent.get(parentA);
                        }

                        String parentB = friendB;
                        while(!parent.get(parentB).equals(parentB)) {
                            parentB = parent.get(parentB);
                        }

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
