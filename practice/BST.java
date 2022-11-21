import java.util.*;

public class BST {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // value, depth of that node

        int N = io.getInt();
        long counter = 0;

        for(int i = 0; i < N; i++) {
            int newValue = io.getInt();
            int newDepth = 0;

            boolean hasLessThan = (treeMap.floorKey(newValue) != null);
            boolean hasGreaterThan = (treeMap.ceilingKey(newValue) != null);

            if(!hasLessThan && !hasGreaterThan) {
                newDepth = 0;
            }

            if(hasLessThan && !hasGreaterThan) {
                newDepth = treeMap.get(treeMap.floorKey(newValue)) + 1;
            }

            if(hasGreaterThan && !hasLessThan) {
                newDepth = treeMap.get(treeMap.ceilingKey(newValue)) + 1;
            }

            if(hasLessThan && hasGreaterThan) {
                int lessThan = treeMap.floorKey(newValue);
                int greaterThan = treeMap.ceilingKey(newValue);

                if(treeMap.get(lessThan) > treeMap.get(greaterThan)) {
                    newDepth = treeMap.get(lessThan) + 1;
                } else if(treeMap.get(lessThan) < treeMap.get(greaterThan)) {
                    newDepth = treeMap.get(greaterThan) + 1;
                }
            }
            treeMap.put(newValue, newDepth);

            counter += newDepth;
            io.println(counter);
        }
        io.flush();
        io.close();
    }
}
