package q2;
import java.util.*;

// fix to count # to knock over = # of sets in graph

public class Dominos {
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> dominos;

    public static void BFS(int input) {
        Queue<Integer> queueOfDominos = new LinkedList<>();
        ArrayList<Integer> nextDominos = dominos.get(input);

        for(int i : nextDominos) {
            queueOfDominos.add(i);
        }

        while(!queueOfDominos.isEmpty()) {
            int currentDomino = queueOfDominos.poll();
            if(!visited[currentDomino]) {
                visited[currentDomino] = true;
                ArrayList<Integer> currentNextDominos = dominos.get(currentDomino);
                for(int i : currentNextDominos) {
                    queueOfDominos.add(i);
                }
            }
        }
    } 
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int numOfTestCases = io.getInt();
        for(int i = 0; i < numOfTestCases; i++) {
            int numOfDominos = io.getInt();
            int numOfRelations = io.getInt();

            dominos = new HashMap<>(); // <domino id, next dominos>        
            visited = new boolean[numOfDominos];

            for(int j = 0; j < numOfDominos; j++) {
                dominos.put(j, new ArrayList<>());
                visited[j] = false;
            }

            for(int j = 0; j < numOfRelations; j++) {
                int start = io.getInt() - 1;
                int end = io.getInt() - 1;
                dominos.get(start).add(end);
            }

            int numberToKnock = 0;
            for(int j = 0; j < numOfDominos; j++) {
                if(!visited[j]) {
                    numberToKnock += 1;
                    BFS(j);
                }
            }

            io.println(numberToKnock);
        }
        io.flush();
    }
}
