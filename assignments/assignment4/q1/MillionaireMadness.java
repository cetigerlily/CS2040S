import java.util.*;
import java.lang.*;
import java.io.*;

public class MillionaireMadness {
    static int m;
    static int n;

    static CoinStack[][] coinGrid;
    static boolean[][] visited;

    static ArrayList<Ladder> pathTaken; // list of ladders used for min path 
    static PriorityQueue<Ladder> queue;

    // number of vertices = m * n

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        m = io.getInt();
        n = io.getInt();

        coinGrid = new CoinStack[m][n];
        visited = new boolean[m][n];
        pathTaken = new ArrayList<>();
        queue = new PriorityQueue<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                coinGrid[i][j] = new CoinStack(i, j, io.getInt());
                visited[i][j] = false;
            }
        }
        
        CoinStack NW = coinGrid[0][0];
        CoinStack SE = coinGrid[m - 1][n - 1];

        queue.add(new Ladder(NW, NW));

        while(!queue.isEmpty()) {
            Ladder current = queue.poll();

            if(!visited[current.getEnd().getX()][current.getEnd().getY()]) {
                visited[current.getEnd().getX()][current.getEnd().getY()] = true;
                pathTaken.add(current);
                BFS(current.getEnd());

                if(current.getEnd().equals(SE)) {
                    System.out.println("stopping search now...");
                    break;
                }
            }
        }

        // ERROR: it just returns the original value of shortestLadder
        int shortestLadder = 0;
        for(Ladder ladder : pathTaken) {
            if(ladder.getLength() > shortestLadder) {
                shortestLadder = ladder.getLength();
            }
        }

        io.println(shortestLadder);
        io.flush();
    }

    public static void BFS(CoinStack input) {
        int thisX = input.getX();
        int thisY = input.getY();

        if((thisX - 1 >= 0) && (!visited[thisX - 1][thisY])) { // above: m - 1, n
        // check condition and if it has been visited already or not
            visited[thisX - 1][thisY] = true;
            CoinStack neighbour = coinGrid[thisX - 1][thisY];
            Ladder thisLadder = new Ladder(input, neighbour);
            System.out.println("A");
            queue.add(thisLadder);
        }

        // below: m + 1, n
        if(thisX + 1 < m) {
            visited[thisX + 1][thisY] = true;
            CoinStack neighbour = coinGrid[thisX + 1][thisY];
            Ladder thisLadder = new Ladder(input, neighbour);
            System.out.println("B");
            queue.add(thisLadder);
        }

        // left: m, n - 1
        if(thisY - 1 >= 0) {
            visited[thisX][thisY - 1] = true;
            CoinStack neighbour = coinGrid[thisX][thisY - 1];
            Ladder thisLadder = new Ladder(input, neighbour);
            System.out.println("C");
            queue.add(thisLadder);
        }

        // right: m, n + 1
        if(thisY + 1 < n) {
            visited[thisX][thisY + 1] = true;
            CoinStack neighbour = coinGrid[thisX][thisY + 1];
            Ladder thisLadder = new Ladder(input, neighbour);
            System.out.println("D");
            queue.add(thisLadder);
        }
    }
}
