import java.util.*;

public class Promotions {
    static HashMap<Integer, ArrayList<Integer>> children;
    static HashMap<Integer, ArrayList<Integer>> parent;
    static boolean[] visited;

    static ArrayList<Integer> sorted;
    static int[] indegree;
    static Queue<Integer> sorting;
    
    static int[] topoSort1;
    static int[] topoSort2;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int a = io.getInt();
        int b = io.getInt();

        int numofEmployees = io.getInt();
        int numOfRules = io.getInt();

        children = new HashMap<>(); // <employee index, list of employees only promoted after them>
        parent = new HashMap<>();
        visited = new boolean[numofEmployees];
        for(int i = 0; i < numofEmployees; i++) {
            children.put(i, new ArrayList<>());
            parent.put(i, new ArrayList<>());
            visited[i] = false;
        }

        sorted = new ArrayList<>();
        indegree = new int[numofEmployees];
        for(int i = 0; i < numOfRules; i++) {
            int x = io.getInt();
            int y = io.getInt();

            children.get(x).add(y);
            parent.get(y).add(x);
            indegree[y] += 1;
        }

        sorting = new LinkedList<>();
        for(int i = 0; i < numofEmployees; i++) {
            if(indegree[i] == 0) {
                sorting.add(i);
            }
        }

        topoSort1 = new int[numofEmployees];
        topoSort2 = new int[numofEmployees];
        for(int i = 0; i < numofEmployees; i++) {
            topoSort1(i);
            topoSort2(i);
        }

        int definitelyA = 0;
        int definitelyB = 0;
        int neverB = 0;

        for(int i = 0; i < numofEmployees; i++) {
            if(topoSort1[i] < a) {
                definitelyA += 1;
            }

            if(topoSort1[i] < b) {
                definitelyB += 1;
            }

            if(topoSort2[i] >= b) {
                neverB += 1;
            }
        }

        io.println(definitelyA);
        io.println(definitelyB);
        io.println(neverB);

        io.flush();
        io.close();
    }

    public static void topoSort1(int input) {
        int count = 0;
        // this is one version where least above comes first
        while(!sorting.isEmpty()) {
            int thisEmployee = sorting.poll();
            // sorted.add(thisEmployee);
            if(thisEmployee == input) {
                continue;
            }
            count += 1;

            for(int i : children.get(thisEmployee)) {
                indegree[i] -= 1;
                if(indegree[i] == 0) {
                    sorting.add(i);
                }
            }
        }
        topoSort1[input] = count;
    }

    public static void topoSort2(int input) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(input);
        visited[input] = true;
        
        int count = 0; 
        while(!queue.isEmpty()) {
            int thisEmployee = queue.poll();
            for(int i : parent.get(thisEmployee)) {
                if(!visited[i]) {
                    count += 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        topoSort2[input] = count;
    }
}
