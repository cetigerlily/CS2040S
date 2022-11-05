import q2.Kattio;
import java.util.*;

public class MillionaireMadness {
    static int M;
    static int N;

    static int[][] coinstackHeight;
    static boolean[][] visited;

    static PriorityQueue<Ladder> pq;
    static ArrayList<Ladder> pathTaken;

    static int[] moveM = {0, 0, 1, -1};
    static int[] moveN = {1, -1, 0, 0};

    public static void BFS(Coinstack input) {
        // make new ladders for each of the neighbours and add it to the pq

        for(int i = 0; i < 4; i++) {
            int newM = input.getM() + moveM[i];
            int newN = input.getN() + moveN[i];

            if((newM >= 0) && (newM < M) && (newN >= 0) && (newN < N) && (!visited[newM][newN])) {
                visited[newM][newN] = true;
                Coinstack neighbourCoinstack = new Coinstack(newM, newN);
                int difference = Math.max(0, neighbourCoinstack.getHeight() - input.getHeight());
                pq.add(new Ladder(difference, input, neighbourCoinstack));
            }
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        M = io.getInt(); // rows
        N = io.getInt(); // columns
        coinstackHeight = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                coinstackHeight[i][j] = io.getInt();
                visited[i][j] = false;
            }
        }

        pq = new PriorityQueue<>(); // PQ of ladders
        pathTaken = new ArrayList<>();
        Coinstack start = new Coinstack(0, 0);
        Coinstack end = new Coinstack(M - 1, N - 1);

        pq.add(new Ladder(0, start, start));
        while(!pq.isEmpty()) {
            Ladder thisLadder = pq.poll();

            if((thisLadder.getEnd().getM() == M - 1) && (thisLadder.getEnd().getN() == N - 1)) {
                System.out.println("Reached the end");
                break;
            }

            if(!visited[thisLadder.getEnd().getM()][thisLadder.getEnd().getN()]) {
                visited[thisLadder.getEnd().getM()][thisLadder.getEnd().getN()] = true;
                pathTaken.add(thisLadder);
                BFS(thisLadder.getEnd());
            }
        }

        int shortestLadder = 0;
        for(int i = 0; i < pathTaken.size(); i++) {
            if(pathTaken.get(i).getLength() > shortestLadder) {
                shortestLadder = pathTaken.get(i).getLength();
            }
        }

        io.println(shortestLadder);
        io.flush();
    }
}

class Coinstack {
    private int m;
    private int n;
    private int height;

    public Coinstack(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return this.m;
    }

    public int getN() {
        return this.n;
    }

    public int getHeight() {
        return MillionaireMadness.coinstackHeight[this.getM()][this.getN()];
    }

    @Override
    public boolean equals(Object object) {
        if(object.getClass() != this.getClass()) {
            return false;
        } else {
            Coinstack temp = (Coinstack) object;
            if((this.getM() == temp.getM()) && (this.getN() == temp.getN())) {
                return true;
            } else {
                return false;
            }
        }
    }
}

class Ladder implements Comparable<Ladder> {
    private int length;
    private Coinstack start;
    private Coinstack end;
    
    public Ladder(int length, Coinstack start, Coinstack end) {
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return this.length;
    }

    public Coinstack getStart() {
        return this.start;
    }

    public Coinstack getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(Ladder other) {
        return this.getLength() - other.getLength();
    }
}
