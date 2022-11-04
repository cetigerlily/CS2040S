package q2;
import java.util.*;

public class Dominos {
    static int numOfDominos;

    static boolean[] sorted;
    static boolean[] knockedOver;

    static HashMap<Integer, ArrayList<Integer>> dominos;
    static Stack<Integer> sortedDominos;

    public static void DFS(int id) {
        knockedOver[id] = true;
        for(int i = 0; i < dominos.get(id).size(); i++) {
            int nextDomino = dominos.get(id).get(i);
            if(!knockedOver[nextDomino]) {
                DFS(nextDomino);
            }
        }
    }

    public static void topoSort(int id) {
        sorted[id] = true;
        for(int i = 0; i < dominos.get(id).size(); i++) {
            int nextDomino = dominos.get(id).get(i);
            if(!sorted[nextDomino]) {
                topoSort(dominos.get(id).get(i));
            }
        }
        sortedDominos.push(id);
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            numOfDominos = io.getInt();
            int numOfRelations = io.getInt();

            dominos = new HashMap<>(); // <domino id, next dominos>        
            sorted = new boolean[numOfDominos];

            for(int j = 0; j < numOfDominos; j++) {
                dominos.put(j, new ArrayList<>());
                sorted[j] = false;
            }

            for(int j = 0; j < numOfRelations; j++) { // adjList
                int start = io.getInt() - 1;
                int end = io.getInt() - 1;

                dominos.get(start).add(end);
            }

            sortedDominos = new Stack<>();
            for(int j = 0; j < numOfDominos; j++) {
                if(!sorted[j]) {
                    topoSort(j);
                }
            }

            knockedOver = new boolean[numOfDominos];
            int numToKnock = 0;

            while(!sortedDominos.empty()) {
                int nextDomino = sortedDominos.pop();
                if(!knockedOver[nextDomino]) {
                    numToKnock += 1;
                    DFS(nextDomino);
                }
            }
            io.println(numToKnock);
        }
        io.flush();
    }
}
