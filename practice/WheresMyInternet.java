import java.util.*;

public class WheresMyInternet {
    static int numOfHouses; // vertices
    static int numOfNetworkCables; // edges

    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> houses;
    
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

        boolean moreComponents = false;
        DFS(0);

        for(int i = 0; i < numOfHouses; i++) {
            if(!visited[i]) {
                moreComponents = true;
                break;
            }
        }

        if(!moreComponents) {
            io.println("Connected");
        } else {
            for(int i = 0; i < numOfHouses; i++) {
                if(!visited[i]) {
                    io.println(i + 1);
                }
            }
        }
        io.flush();
    }
    
    public static void DFS(int house) {
        visited[house] = true;

        for(int i = 0; i < houses.get(house).size(); i++) {
            int nextHouse = houses.get(house).get(i);
            if(!visited[nextHouse]) {
                DFS(nextHouse);
            }
        }
    }
}
