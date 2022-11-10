import java.util.*;

public class HumanCannonBallRun {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        Point origin = new Point(io.getDouble(), io.getDouble());
        Point destination = new Point(io.getDouble(), io.getDouble());

        int numOfCannons = io.getInt();
        int numOfVertices = numOfCannons + 2;

        boolean[] visited = new boolean[numOfVertices];
        Point[] cannons = new Point[numOfCannons]; // cannons[i] gives the point of cannon index i

        for(int i = 0; i < numOfCannons; i++) {
            visited[i] = false;
            cannons[i] = new Point(io.getDouble(), io.getDouble());
        }

        double[][] adjMatrix = new double[numOfVertices][numOfVertices]; // adjMatrix[i][j] gives the time between i and j, i and j are two vertices - origin + destiantion @ start and cannon + 2

        double distToDestination = Math.hypot(Math.abs(origin.getX() - destination.getX()), Math.abs(origin.getY() - destination.getY()));
        double timeToDestination = distToDestination / 5;
        adjMatrix[0][1] = timeToDestination;
        adjMatrix[1][0] = timeToDestination;

        // from each cannon to another cannon
        for(int i = 0; i < numOfCannons; i++) {
            for(int j = 0; j < numOfCannons; j++) {
                double distanceTotal = Math.sqrt(Math.pow((cannons[i].getX() - cannons[j].getX()), 2) + Math.pow((cannons[i].getY() - cannons[j].getY()), 2));
                double distanceRun = Math.abs(distanceTotal - 50);
                double time = 2 + (distanceRun / 5);

                adjMatrix[i + 2][j + 2] = time; 
            }
        }

        // from each cannon to origin
        for(int i = 0; i < numOfCannons; i++) {
            double distanceTotal = Math.hypot(origin.getX() - cannons[i].getX(), origin.getY() - cannons[i].getY());
            double distanceRun = Math.abs(distanceTotal - 50);
            
            double timeOrigin = distanceTotal / 5; // time from origin to cannon
            double timeCannon = 2 + (distanceRun / 5); // time from cannon to origin
            
            adjMatrix[0][i + 2] = timeOrigin; 
            adjMatrix[i + 2][0] = timeCannon;
        }

        // from each cannon to destination
        for(int i = 0; i < numOfCannons; i++) {
            double distanceTotal = Math.hypot(destination.getX() - cannons[i].getX(), destination.getY() - cannons[i].getY());
            double distanceRun = Math.abs(distanceTotal - 50);

            double timeDestination = distanceTotal / 5; // time from destination to cannon
            double timeCannon = 2 + (distanceRun / 5); // time from cannon to destination

            adjMatrix[1][i + 2] = timeDestination;
            adjMatrix[i + 2][1] = timeCannon;
        }

        double[] timing = new double[numOfVertices];
        for(int i = 0; i < numOfVertices; i++) {
            timing[i] = Double.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge startEdge = new Edge(0, 0);
        pq.add(startEdge); 

        while(!pq.isEmpty()) {
            Edge thisEdge = pq.poll(); // current vertex's index

            if(!visited[thisEdge.getIndex()]) {
                visited[thisEdge.getIndex()] = true;
                
                for(int i = 0; i < numOfVertices; i++) {
                    if((!visited[i]) && (i != thisEdge.getIndex())) {
                        double newTime = thisEdge.getWeight() + adjMatrix[thisEdge.getIndex()][i];
                        if(timing[i] > newTime) {
                            timing[i] = newTime;
                            pq.add(new Edge(i, timing[i]));
                        }
                    }
                }
            }
        }

        io.println(timing[1]);
        io.flush();
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
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

class Edge implements Comparable<Edge> {
    private int startIndex;
    private double weight;

    public Edge(int startIndex, double weight) {
        this.startIndex = startIndex;
        this.weight = weight;
    }

    public int getIndex() {
        return this.startIndex;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge other) {
        if(this.getWeight() < other.getWeight()) {
            return -1;
        } else if(this.getWeight() > other.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
