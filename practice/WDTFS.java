/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class WDTFS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numOfTestCases = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<String>> testCases = new HashMap<>(); // <integer of test case, list of noises
        
        for(int i = 0; i < numOfTestCases; i++) {
            String[] input = br.readLine().split(" ");
            ArrayList<String> thisTestCase = new ArrayList<>();

            for(int j = 0; j < input.length; j++) {
                thisTestCase.add(input[j]);
            }
            testCases.put(i, thisTestCase);
        }

        // store the animal inputs
        HashSet<String> animals = new HashSet<>(); // <animal noise> ie. NOT fox noises
        while(true) {
            String input = br.readLine();
            if(input.equals("what does the fox say?")) {
                break;
            } else {
                String[] animalInfo = input.split(" ");
                animals.add(animalInfo[2]);
            }
        }

        for(int k = 0; k < numOfTestCases; k++) {
            // iterate through the testcases' list of noises
            for(int l = 0; l < testCases.get(k).size(); l++) {
                if(!(animals.contains(testCases.get(k).get(l)))) {
                    pw.print(testCases.get(k).get(l));
                    if(l != testCases.get(k).size() - 1) {
                        pw.print(" ");
                    }
                }
            }
            if(k != numOfTestCases - 1) {
                pw.print("\n");
            }
        }
        pw.flush();
    }
}
