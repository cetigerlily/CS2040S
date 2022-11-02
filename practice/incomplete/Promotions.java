import java.util.*;
import java.io.*;
import java.lang.*;

/* PSEUDO-CODE:
 * 
 * 1) Keep a structure of all the employees - each Employee has an ID and has two HashSets tracking the employee relationships
 * 2) Start search with all employees with a parents size of 0 - then visit the employees in the children
 * 3) For each employee during the search, if all it's parents employees have already been visited, then can continue search with it, else, go to visit it's unvisited parents (add parents to queue)
 * 4) 
 */


/*
 * Each employee has an in-degree - order the employees based on their in-degree
 * Add all employees with an in-degree of 0 into the queue and then BFS each one of them - search through their children
 */

public class Promotions {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int A = io.getInt();
        int B = io.getInt();
        int numOfEmployees = io.getInt();
        int numOfEdges = io.getInt();

        boolean[] visited = new boolean[numOfEmployees];
        HashMap<Integer, Integer> greaterThan = new HashMap<>(); // <employee ID, indegree>, stores the number of employees greater than employee id i
        
        for(int i = 0; i < numOfEmployees; i++) {
            greaterThan.put(i, 0);
            visited[i] = false;
        }

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numOfEdges; i++) { // x -> y, x outperforms y
            int X = io.getInt();
            int Y = io.getInt();

            if(!adjList.containsKey(X)) {
                adjList.put(X, new ArrayList<>());
            }
            adjList.get(X).add(Y); // add Y to X's adjList
            greaterThan.put(Y, greaterThan.get(Y) + 1); // update the indegree of Y
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numOfEmployees; i++) {
            if(greaterThan.get(i) == 0) {
                queue.add(i); // add the employees with in-degree of 0
                visited[i] = true;
            }
        }

        // each employee with an in-degree of 0 should have it's own "path" eg
        // now search through 
        while(!queue.isEmpty()) {
            int currentEmployee = queue.poll();


        }

        // count the number of parents an employee has 

    }
}
