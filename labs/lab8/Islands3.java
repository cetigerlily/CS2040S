import java.util.*;

public class Islands3 {
    static int r;
    static int c;
    static char[][] islandGrid;
    static boolean[][] visited;

    public static void BFS(Land input) {
        Queue<Land> queueOfLand = new LinkedList<>();
        queueOfLand.add(input);

        while(!queueOfLand.isEmpty()) {
            Land thisLand = queueOfLand.poll();
            int thisR = thisLand.getR();
            int thisC = thisLand.getC();

            if(thisR - 1 >= 0) { // above: r - 1, c
                if((!visited[thisR - 1][thisC]) && (islandGrid[thisR - 1][thisC] == 'L' || islandGrid[thisR - 1][thisC] == 'C')) {
                queueOfLand.add(new Land(thisR - 1, thisC));
                visited[thisR - 1][thisC] = true;
                }
            }

            if(thisR + 1 < r) { // below: r + 1, c
                if((!visited[thisR + 1][thisC]) && (islandGrid[thisR + 1][thisC] == 'L' || islandGrid[thisR + 1][thisC] == 'C')) {
                    queueOfLand.add(new Land(thisR + 1, thisC));
                    visited[thisR + 1][thisC] = true;
                }
            }

            if(thisC + 1 < c) { // right: r, c + 1
                if((!visited[thisR][thisC + 1]) && (islandGrid[thisR][thisC + 1] == 'L' || islandGrid[thisR][thisC + 1] == 'C')) {
                    queueOfLand.add(new Land(thisR, thisC + 1));
                    visited[thisR][thisC + 1] = true;
                }
            }

            if(thisC - 1 >= 0) { // left: r, c - 1
                if((!visited[thisR][thisC - 1]) && (islandGrid[thisR][thisC - 1] == 'L' || islandGrid[thisR][thisC - 1] == 'C')) {
                queueOfLand.add(new Land(thisR, thisC - 1));
                visited[thisR][thisC - 1] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        r = io.getInt();
        c = io.getInt();

        islandGrid = new char[r][c];
        visited = new boolean[r][c];
        Queue<Land> land = new LinkedList<>();
        
        for(int i = 0; i < r; i++) {
            
            char[] input = io.getWord().toCharArray();
            for(int j = 0; j < input.length; j++) {
                islandGrid[i][j] = input[j];
                visited[i][j] = false;

                if(input[j] == 'L') {
                    land.add(new Land(i, j));
                }
            }
        }

        int islandCount = 0;
        while(!land.isEmpty()) {
            Land thisLand = land.poll();
            if(!visited[thisLand.getR()][thisLand.getC()]) {
                BFS(thisLand);
                islandCount += 1;
            }
        }

        io.println(islandCount);
        io.flush();
    }
}
