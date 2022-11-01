import java.util.*;
import java.io.*;
import java.lang.*;
import java.security.cert.PolicyQualifierInfo;
import java.awt.*;

public class Grasshopper {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            int R = io.getInt();
            int C = io.getInt();
            int gR = io.getInt();
            int gC = io.getInt();
            int lR = io.getInt();
            int lC = io.getInt();
    
            int index = 0;
            int vertex[][] = new int[R][C];
            for(int i = 1; i <= R; i++) {
                for(int j = 1; j <= C; j++) {
                    vertex[i][j] = index;
                    index += 1;
                }
            }
    
            int distance[][] = new int[R][C]; // distance array from source to a vertex ie. distance[i][j] = distance of vertex[i][j] to source
            int previous[][] = new int[R][C]; // previous vertex
    
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                    previous[i][j] = -1;
                    queue.add(vertex[i][j]);
                }
            }

            distance[gR][gC] = 0;

            while(!queue.isEmpty()) {
                int current = queue.poll();
                if(current == vertex[lR][lC]) {
                    break;
                }
                BFS(current); // search for each neighbour v of current in Q
            }
        }
        io.flush();
    }
}
