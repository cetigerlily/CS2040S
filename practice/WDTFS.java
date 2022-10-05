import java.util.*;
import java.lang.*;
import java.io.*;

public class WDTFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numOfTestCases = Integer.parseInt(br.readLine());

        for(int i = 0; i < numOfTestCases; i++) {
            String[] thisTestCase = br.readLine().split(" ");

            HashSet<String> animalSounds = new HashSet<>();
            while(true) {
                String[] input = br.readLine().split(" ");
                if(input[0].equals("what")) {
                    break;
                } else {
                    animalSounds.add(input[2]);
                }
            }

            StringBuilder foxNoises = new StringBuilder();
            for(int k = 0; k < thisTestCase.length; k++) {
                if(!(animalSounds.contains(thisTestCase[k]))) {
                    foxNoises.append(thisTestCase[k] + " ");
                }
            }
            pw.println(foxNoises.toString());
        }
        pw.flush();
    }
}
