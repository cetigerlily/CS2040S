import java.util.*;

public class MillionaireMadness {
    static int m;
    static int n;

    static int[][] coinStackHeight;
    static boolean[][] visited;
    
    static PriorityQueue<Ladder> pq;
    static ArrayList<Ladder> duckPath;

    static int[] moveM = {-1, 1, 0, 0};
    static int[] moveN = {0, 0, -1, 1};

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        m = io.getInt(); // rows
        n = io.getInt(); // columns
        coinStackHeight = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                coinStackHeight[i][j] = io.getInt(); // heights of coinstacks
                visited[i][j] = false; // visit status of coinstacks
            }
        }

        pq = new PriorityQueue<>();
        duckPath = new ArrayList<>();

        CoinStack NW = new CoinStack(0, 0);
        CoinStack SE = new CoinStack(m - 1, n - 1);
        Ladder start = new Ladder(NW, NW);

        pq.add(start);
        while(!pq.isEmpty()) {
            Ladder currentLadder = pq.poll();
            int endM = currentLadder.getEnd().getM();
            int endN = currentLadder.getEnd().getN();

            if(!visited[endM][endN]) {
                visited[endM][endN] = true;
                duckPath.add(currentLadder);
                BFS(currentLadder.getEnd());
            }

            if((endM == SE.getM()) && (endN == SE.getN())) {
                break;
            }
        }

        int shortestLadder = 0;
        for(int i = 0; i < duckPath.size(); i++) {
            if(duckPath.get(i).getLength() > shortestLadder) {
                shortestLadder = duckPath.get(i).getLength();
            }
        }
        io.println(shortestLadder);
        io.flush();
    }

    public static void BFS(CoinStack input) {
        int currentM = input.getM();
        int currentN = input.getN();

        for(int i = 0; i < 4; i++) {
            int newM = currentM + moveM[i];
            int newN = currentN + moveN[i];

            if((newM >= 0) && (newM < m) && (newN >= 0) && (newN < n)) {
                CoinStack neighbour = new CoinStack(newM, newN);
                Ladder nextLadder = new Ladder(input, neighbour);
                pq.add(nextLadder);
            }
        }
    }
}
