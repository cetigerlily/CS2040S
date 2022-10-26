import java.io.*;

public class Skener {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int Zr = Integer.parseInt(input[2]);
        int Zc = Integer.parseInt(input[3]);

        for(int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            StringBuilder outputLine = new StringBuilder();

            for(int j = 0; j < C; j++) {
                for(int k = 0; k < Zc; k++) {
                    outputLine.append(line[j]);
                }
            }

            for(int j = 0; j < Zr; j++) {
                pw.println(outputLine);
            }
        }
        pw.flush();
    }
}
