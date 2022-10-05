import java.util.*;
import java.lang.*;
import java.io.*;

public class IntegerLists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numOfTestCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < numOfTestCases; i++) {
            String[] BAPC = br.readLine().split("");
            int numOfElements = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split("");
            
            Stack<String> ogElements = new Stack<>();
            for(int j = 0; j < input.length; j++) {
                if((input[j].equals("[")) || (input[j].equals(",")) || (input[j].equals("]"))) {
                    continue;
                } else {
                    ogElements.push(input[j]);
                }
            }

            Stack<String> startingElements = ogElements;
            Stack<String> endingElements = new Stack<>();

            for(int k = 0; k < BAPC.length; k++) {
                if(BAPC[k].equals("D") && !(startingElements.empty())) {
                    startingElements.pop();
                    if(!(startingElements.empty())) {
                        pw.println(startingElements);
                    } else if(startingElements.empty()) {
                        pw.println("error");
                    }
                }

                if(BAPC[k].equals("R") && !(startingElements.empty())) {
                    for(int l = 0; l < numOfElements; l++) {
                        endingElements.push(startingElements.pop());
                    }
                    pw.println(endingElements);
                    startingElements = endingElements; // reset them for the next instruction
                    endingElements.clear();
                }
            }
        }
        pw.flush();
    }
}
