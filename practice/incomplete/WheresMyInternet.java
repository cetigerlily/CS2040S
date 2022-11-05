import java.util.*;

public class Internet {
    static int numOfHouses; // vertices
    static int numOfNetworkCables; // edges

    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> houses;
    static HashMap<Integer, ArrayList<Integer>> unconnectedHouses;
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        numOfHouses = io.getInt();
        numOfNetworkCables = io.getInt();

        visited = new boolean[numOfHouses];
        houses = new HashMap<>();
        
        for(int i = 0; i < numOfHouses; i++) {
            visited[i] = false;
            houses.put(i, new ArrayList<>()); // 0-index, later +1 for result
        }

        for(int i = 0; i < numOfNetworkCables; i++) {
            int a = io.getInt() - 1;
            int b = io.getInt() - 1;

            houses.get(a).add(b); // adding a->b
            houses.get(b).add(a); // also adding b->a since undirected
        }

        int numOfComponents = 0;
        unconnectedHouses = new HashMap<>();

        for(int i = 0; i < numOfHouses; i++) {
            if(!visited[i]) {
                unconnectedHouses.put(numOfComponents, new ArrayList<>());
                DFS(i, unconnectedHouses.get(numOfComponents));
                numOfComponents += 1;
            }
        }

        if(numOfComponents == 1) {
            io.println("Connected");
        } else {
            for(int i = 1; i < numOfComponents; i++) {
                ArrayList<Integer> currentComponent = unconnectedHouses.get(i);
                Collections.sort(currentComponent);
                for(int j : currentComponent) {
                    io.println(j + 1);
                }
            }
        }
        io.flush();
    }
    
    public static void DFS(int house, ArrayList<Integer> thisComponent) {
        visited[house] = true;
        thisComponent.add(house);

        for(int i = 0; i < houses.get(house).size(); i++) {
            int nextHouse = houses.get(house).get(i);
            if(!visited[nextHouse]) {
                DFS(nextHouse, thisComponent);
            }
        }
    }
}
