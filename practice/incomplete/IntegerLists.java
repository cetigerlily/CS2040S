import java.util.*;
import java.io.*;

public class IntegerLists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numOfTestCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < numOfTestCases; i++) {
            String[] BAPC = br.readLine().split("");
            int numOfElements = Integer.parseInt(br.readLine());

            String temp = br.readLine();
            String[] elements;

            if(temp.length() > 2) {
                elements = temp.substring(1, temp.length() - 1).split(",");
            } else {
                elements = new String[0];
            }

            Deque<Integer> integerList = new LinkedList<>();
            for(int j = elements.length - 1; j >= 0; j--) {
                integerList.addFirst(Integer.parseInt(elements[j]));
            }

            Deque<Integer> starting = integerList;
            Deque<Integer> ending = new LinkedList<>();

            for(int j = 0; j < BAPC.length; j++) {
                if(BAPC[j].equals("R")) {
                    for(int k = 0; k < numOfElements; k++) {
                        ending.addFirst(starting.removeFirst());
                    }
                    starting = ending;
                    ending = new LinkedList<>();
                }
                
                if(BAPC[j].equals("D")) {
                    if(starting.isEmpty()) {
                        pw.println("error");
                        break;
                    } else {
                        starting.removeFirst();
                    }
                }

                if(j == BAPC.length - 1) {
                    pw.println(starting.toString().replaceAll("\\s", ""));
                }
            }
        }
        pw.flush();
    }
}
