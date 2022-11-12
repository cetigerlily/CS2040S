import java.util.*;

public class ArticNetwork {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            int numOfSatellite = io.getInt();
            int numOfOutpost = io.getInt();

            boolean[] visited = new boolean[numOfOutpost];
            Outpost[] outposts = new Outpost[numOfOutpost];
            double[] distances = new double[numOfOutpost]; // minimum distances needed to reach a certain outpost

            for(int j = 0; j < numOfOutpost; j++) {
                int x = io.getInt();
                int y = io.getInt();

                visited[j] = false;
                outposts[j] = new Outpost(x, y, j);
                distances[j] = Double.MAX_VALUE;
            }

            double[][] adjMatrix = new double[numOfOutpost][numOfOutpost];
            for(int j = 0; j < numOfOutpost; j++) {
                for(int k = 0; k < numOfOutpost; k++) {
                    double distance = Math.hypot(Math.abs(outposts[j].getX() - outposts[k].getX()), Math.abs(outposts[j].getY() - outposts[k].getY()));
                    adjMatrix[j][k] = distance;
                }
            }

            int numOfConnected = 0;

            Distance start = new Distance(outposts[0], adjMatrix[0][0]);
            PriorityQueue<Distance> pq = new PriorityQueue<>();

            pq.add(start);
            while(!pq.isEmpty()) {
                Distance thisDistance = pq.poll();
                if(!visited[thisDistance.getStart().getIndex()]) {
                    visited[thisDistance.getStart().getIndex()] = true;
                }

                for(int j = 0; j < numOfOutpost; j++) {
                    if((!visited[j]) && (i != thisDistance.getStart().getIndex())) {
                        double newDistance = thisDistance.getLength() + adjMatrix[thisDistance.getStart().getIndex()][j];
                        if(distances[j] > newDistance) {
                            distances[j] = newDistance;
                            pq.add(new Distance(outposts[j], distances[j]));
                        }
                    }
                }
            }

            // have to do a different "stop" measure since not all have to be connected

            io.flush();
        }
    }
}

class Outpost {
    private int x;
    private int y;
    private int index;

    public Outpost(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getIndex() {
        return this.index;
    }
}

class Distance implements Comparable<Distance> {
    private Outpost start;
    private double length;

    public Distance(Outpost start, double length) {
        this.start = start;
        this.length = length;
    }

    public Outpost getStart() {
        return this.start;
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public int compareTo(Distance other) {
        if(this.getLength() > other.getLength()) {
            return 1;
        } else if(this.getLength() < other.getLength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
