import java.util.*;
import java.lang.*;
import java.io.*;

public class DelimiterSoup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int lengthOfLine = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(""); // some will be null

        Stack<String> openDelimit = new Stack<>();
        int error = 0; // will be 1 if any error has been detected

        for(int i = 0; i < lengthOfLine; i++) {
            if(input[i] == null) {
                continue;
            }

            if((input[i].equals("(")) || (input[i].equals("{")) || (input[i].equals("["))) {
                openDelimit.push(input[i]);
            }

            if(input[i].equals(")")) {
                if(openDelimit.empty() || !(openDelimit.pop().equals("("))) {
                    pw.println(input[i] + " " + i);
                    error = 1;
                    break;
                }
            } 

            if(input[i].equals("]")) {
                if(openDelimit.empty() || !(openDelimit.pop().equals("["))) {
                    pw.println(input[i] + " " + i);
                    error = 1;
                    break;
                }
            }
            
            if(input[i].equals("}")) {
                if(openDelimit.empty() || !(openDelimit.pop().equals("{"))) {
                    pw.println(input[i] + " " + i);
                    error = 1;
                    break;
                }
            }
        }

        if(error == 0) {
            pw.println("ok so far");
        }
        pw.flush();
    }
}
