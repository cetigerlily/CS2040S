import java.util.*;
import java.awt.*;

public class Grasshopper {
    static int R;
    static int C;
    static Queue<Vertex> queue;
    static boolean visited[][];
    static int[] moveX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] moveY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void BFS(Vertex input) {
        for(int i = 0; i < 8; i++) {
            int newX = (int) input.getPoint().getX() + moveX[i];
            int newY = (int) input.getPoint().getY() + moveY[i];

            if(newX >= 0 && newX < C && newY >= 0 && newY < R) {
                if(!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Vertex(new Point(newX, newY), input.getDistance() + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            R = io.getInt();
            C = io.getInt();
            int gR = io.getInt() - 1;
            int gC = io.getInt() - 1;
            int lR = io.getInt() - 1;
            int lC = io.getInt() - 1;
    
            visited = new boolean[R][C];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    visited[i][j] = false;
                }
            }

            Point source = new Point(gR, gC);
            Point leaf = new Point(lR, lC);

            queue = new LinkedList<>();
            queue.add(new Vertex(source, 0));
            visited[gR][gC] = true;

            boolean reachedLeaf = false;
            int numberOfHops = 0;
            while(!queue.isEmpty()) {
                Vertex current = queue.poll();
                if(current.getPoint().equals(leaf)) {
                    reachedLeaf = true;
                    numberOfHops = current.getDistance();
                    break;
                }
                BFS(current);
            }

            if(reachedLeaf) {
                io.println(numberOfHops);
            } else {
                io.println("impossible");           
            }
        }
        io.close();
    }
}
