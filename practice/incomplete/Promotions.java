import java.util.*;
import java.io.*;
import java.lang.*;

public class Promotions {
    static boolean[] sorted;
    static boolean[] promoted;

    static HashMap<Integer, ArrayList<Integer>> employees;
    static Stack<Integer> sortedEmployees;

    public static void topoSort(int employee) {
        sorted[employee] = true;
        for(int i = 0; i < employees.get(employee).size(); i++) {
            int nextEmployee = employees.get(employee).get(i);
            if(!sorted[employee]) {
                topoSort(nextEmployee);
            }
        }
        sortedEmployees.push(employee);
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int a = io.getInt();
        int b = io.getInt();
        int numOfEmployees = io.getInt();
        int numOfRules = io.getInt();
        
        sorted = new boolean[numOfEmployees];
        promoted = new boolean[numOfEmployees];
        employees = new HashMap<>();
        
        for(int i = 0; i < numOfEmployees; i++) {
            employees.put(i, new ArrayList<>());
            sorted[i] = false;
        }

        for(int i = 0; i < numOfRules; i++) {
            int x = io.getInt();
            int y = io.getInt();

            employees.get(x).add(y);
        }

        sortedEmployees = new Stack<>();
        for(int i = 0; i < numOfEmployees; i++) {
            if(!sorted[i]) {
                topoSort(i);
            }
        }

        while(!sortedEmployees.isEmpty()) {
            io.println(sortedEmployees.pop());
        }

        int employeesA = 0;
        int employeesB = 0;
        int employeesNever = 0;
        io.flush();
    }
}
