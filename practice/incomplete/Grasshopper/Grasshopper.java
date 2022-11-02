import java.util.*;
import java.awt.*;
import java.io.*;

public class Grasshopper {
    static int[] moveX;
    static int[] moveY;

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

            Point source = new Point(gR, gC);
            Point leaf = new Point(lR, lC);

            Queue<Vertex> queue = new LinkedList<>();
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

                for(int i = 0; i < 8; i++) {
                    int newX = (int) current.getPoint().getX() + moveX[i];
                    int newY = (int) current.getPoint().getY() + moveY[i];
        
                    if((newX >= 0) && (newX < C) && (newY >= 0) && (newY < R) && (!visited[newX][newY])) {
                        visited[newX][newY] = true;
                        queue.add(new Vertex(new Point(newX, newY), current.getDistance() + 1));
                    }
                }
            }
            

            if(reachedLeaf) {
                io.println(numberOfHops);
            } else if(!reachedLeaf) {
                io.println("impossible");           
            }
        }
        io.close();
    }

    public static void moves() {
        moveX = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        moveY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    }
}

class Vertex {
    private Point point;
    private int distance;

    public Vertex(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }

    public Point getPoint() {
        return this.point;
    }

    public int getDistance() {
        return this.distance;
    }
}
