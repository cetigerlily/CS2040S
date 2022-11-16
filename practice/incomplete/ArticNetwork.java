import java.util.*;

public class ArcticNetwork {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            int numOfSatellites = io.getInt();
            int numOfOutposts = io.getInt();

            boolean[] visited = new boolean[numOfOutposts]; // visited[i] = whether or not outpost i has been visited
            Outpost[] outposts = new Outpost[numOfOutposts];
            for(int j = 0; j < numOfOutposts; j++) {
                int x = io.getInt();
                int y = io.getInt();

                outposts[j] = new Outpost(x, y);
                visited[j] = false;
            }

            PriorityQueue<Line> pq = new PriorityQueue<>();
            // distances from 1 outpost to all other outposts
            for(int j = 0; j < numOfOutposts; j++) {
                for(int k = 0; k < numOfOutposts; k++) {
                    if(j != k) {
                        double distance = Math.hypot(outposts[j].getX() - outposts[k].getX(), outposts[j].getY() - outposts[k].getY());
                        pq.add(new Line(k, distance));
                    }
                }
            }

            int numOfLinesNeeded = numOfOutposts - 1 - numOfSatellites;
            double[] distances = new double[numOfLinesNeeded];

            for(int j = 0; j < numOfLinesNeeded; j++) {
                Line thisLine = pq.poll();
                io.println("current index checking is " + thisLine.getEndIndex());
                if(!visited[thisLine.getEndIndex()]) {
                    visited[thisLine.getEndIndex()] = true;
                    distances[j] = thisLine.getLength();
                    io.println("adding... " + thisLine.getLength());
                }
            }
            
            double d = 0;
            for(int j = 0; j < numOfLinesNeeded; j++) {
                io.println(j + " " + distances[j]);
                if(distances[j] > d) {
                    d = distances[j];
                }
            }
            io.println(d);
        }
        io.flush();
        io.close();
    }
}

class Outpost {
    private int x;
    private int y;

    public Outpost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Line implements Comparable<Line> {
    private int endIndex;
    private double length;

    public Line(int endIndex, double length) {
        this.endIndex = endIndex;
        this.length = length;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public int compareTo(Line other) {
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
