import java.util.*;

public class IslandHopping {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();
        for(int i = 0; i < numOfTestCases; i++) {
            int numOfIslands = io.getInt();
            int[] parent = new int[numOfIslands];

            double[] xCoordinate = new double[numOfIslands];
            double[] yCoordinate = new double[numOfIslands];

            for(int j = 0; j < numOfIslands; j++) {
                parent[j] = j; // islands are all initially seperate
                double x = io.getDouble();
                double y = io.getDouble();

                xCoordinate[j] = x;
                yCoordinate[j] = y;

            }

            ArrayList<Bridge> bridges = new ArrayList<>(); // edge list
            for(int j = 0; j < numOfIslands; j++) {
                for(int k = 0; k < numOfIslands; k++) {
                    if(j != k) {
                        double distance = Math.hypot(xCoordinate[j] - xCoordinate[k], yCoordinate[j] - yCoordinate[k]);
                        bridges.add(new Bridge(distance, j, k));
                    }
                }
            }

            Collections.sort(bridges);
            double totalLength = 0;
            int numOfBridges = 0;
            
            // add num of islands - 1
            for(int j = 0; j < bridges.size(); j++) {
                Bridge shortestBridge = bridges.get(0);
                if(findSet(shortestBridge.getStart(), parent) != findSet(shortestBridge.getEnd(), parent)) {
                    totalLength += shortestBridge.getLength();
                    numOfBridges += 1;
                }

                if(numOfBridges == numOfIslands - 1) {
                    break;
                }
            }

            io.println(totalLength);
        }
        io.flush();
        io.close();
    }

    public static int findSet(int index, int[] parent) {
        if(parent[index] == index) {
            return index;
        } else {
            return findSet(parent[index], parent);
        }
    }

    public static void unionSet(int i, int j, int[] parent) {
        int parentI = findSet(i, parent);
        int parentJ = findSet(j, parent);

        parent[parentI] = parentJ;
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

class Bridge implements Comparable<Bridge> {
    private double length;
    private int startIsland;
    private int endIsland;

    public Bridge(double length, int startIsland, int endIsland) {
        this.length = length;
        this.startIsland = startIsland;
        this.endIsland = endIsland;
    }

    public double getLength() {
        return this.length;
    }

    public int getStart() {
        return this.startIsland;
    }

    public int getEnd() {
        return this.endIsland;
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
