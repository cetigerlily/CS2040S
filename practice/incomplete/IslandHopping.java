// over time limit
import java.util.*;

public class IslandHopping {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfCases = io.getInt();

        for(int i = 0; i < numOfCases; i++) {
            int numOfIslands = io.getInt();

            boolean[] visited = new boolean[numOfIslands];
            Island[] islands = new Island[numOfIslands];
            double[][] adjMatrix = new double[numOfIslands][numOfIslands]; // islands[i][j] = distance between i and j

            for(int j = 0; j < numOfIslands; j++) {
                double x = io.getDouble();
                double y = io.getDouble();

                visited[j] = false;
                islands[j] = new Island(x, y);
            }

            for(int j = 0; j < numOfIslands; j++) {
                for(int k = 0; k < numOfIslands; k++) {
                    double distance = Math.hypot(islands[j].getX() - islands[k].getX(), islands[j].getY() - islands[k].getY());
                    adjMatrix[j][k] = distance;
                }
            }

            PriorityQueue<Bridge> pq = new PriorityQueue<>();
            visited[0] = true;

            for(int j = 1; j < numOfIslands; j++) {
                pq.add(new Bridge(j, adjMatrix[0][j]));
            }

            double sumOfLengths = 0;
            while(!pq.isEmpty()) {
                Bridge thisBridge = pq.poll();
                if(!visited[thisBridge.getEndIsland()]) {
                    visited[thisBridge.getEndIsland()] = true;
                    sumOfLengths += thisBridge.getLength();

                    int endIndex = thisBridge.getEndIsland();
                    for(int j = 0; j < numOfIslands; j++) {
                        if(j != endIndex) {
                            pq.add(new Bridge(j, adjMatrix[endIndex][j]));
                        }
                    }
                }
            }
            io.println(sumOfLengths);
        }
        io.flush();
        io.close();
    }
}

class Island {
    private double x;
    private double y;

    public Island(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}

class Bridge implements Comparable<Bridge> {
    private int endIsland;
    private double length;

    public Bridge(int endIsland, double length) {
        this.endIsland = endIsland;
        this.length = length;
    }

    public int getEndIsland() {
        return this.endIsland;
    }
    
    public double getLength() {
        return this.length;
    }

    @Override
    public int compareTo(Bridge other) {
        double result = this.getLength() - other.getLength();
        if(result > 0) {
            return 1;
        } else if(result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
