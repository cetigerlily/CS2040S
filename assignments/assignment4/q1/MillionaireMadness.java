import java.util.*;

public class MillionaireMadness {
    static int m;
    static int n;
    static int[][] coinGrid;
    static boolean[][] visited;

    public static void BFS(CoinStack input) {
        /* PriorityQueue<CoinStack> queueOfCoinStacks = new PriorityQueue()<>();
        queueOfCoinStacks.add(input);

        while(!queueOfCoinStacks.isEmpty()) {
            CoinStack thisCoinStack = queueOfCoinStacks.poll();
            int thisX = thisCoinStack.getX();
            int thisY = thisCoinStack.getY();
            int thisHeight = thisCoinStack.getHeight();

        } */
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        m = io.getInt();
        n = io.getInt();

        coinGrid = new int[m][n];
        visited = new boolean[m][n];
        PriorityQueue<CoinStack> queue = new PriorityQueue<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                coinGrid[i][j] = io.getInt();
                visited[i][j] = false;
            }
        }

        // dijkstra's shortest path
        while(!queue.isEmpty()) {
            CoinStack current = queue.poll();
            int currentX = current.getX();
            int currentY = current.getY();

            if(!visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                BFS(current);
            }
            
            /*
             * if(visited) - don't do anything
             * else, add it to the visited and then go to it's neighbours (BFS)
             */
        }
        

    }
}
