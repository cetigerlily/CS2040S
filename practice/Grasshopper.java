import java.util.*;

public class Grasshopper {
    static int[] moveC;
    static int[] moveR;

    public static void main(String[] args) {
        moves();
        Kattio io = new Kattio(System.in, System.out);

        while(true) {
            if(!io.hasMoreTokens()) {
                break;
            }

            int R = io.getInt();
            int C = io.getInt();
            int gR = io.getInt() - 1;
            int gC = io.getInt() - 1;
            int lR = io.getInt() - 1;
            int lC = io.getInt() - 1;
    
            boolean[][] visited = new boolean[R][C];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    visited[i][j] = false;
                }
            }

            Queue<Vertex> queue = new LinkedList<>();
            queue.add(new Vertex(gR, gC, 0));
            visited[gR][gC] = true;

            boolean reachedLeaf = false;

            while(!queue.isEmpty()) {
                Vertex current = queue.poll();

                if((current.getC() == lC) && (current.getR() == lR)) {
                    reachedLeaf = true;
                    io.println(current.getDistance());
                    break;
                }

                for(int i = 0; i < 8; i++) {
                    int newR = current.getR() + moveR[i];
                    int newC = current.getC() + moveC[i];
        
                    if((newR >= 0) && (newR < R) && (newC >= 0) && (newC < C) && (!visited[newR][newC])) {
                        visited[newR][newC] = true;
                        queue.add(new Vertex(newR, newC, current.getDistance() + 1));
                    }
                }
            }
            
            if(!reachedLeaf) {
                io.println("impossible");           
            }
        }
        io.close();
    }

    public static void moves() {
        moveR = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        moveC = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    }
}

class Vertex {
    private int r;
    private int c;
    private int distance;

    public Vertex(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }

    public int getR() {
        return this.r;
    }

    public int getC() {
        return this.c;
    }

    public int getDistance() {
        return this.distance;
    }
}
