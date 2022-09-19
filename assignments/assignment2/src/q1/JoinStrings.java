package q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;

public class JoinStrings {
    public static void main(String[] args) throws Exception {apackage q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class JoinStrings {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        Kattio io = new Kattio(System.in, System.out);
        int numOfWords = Integer.parseInt((io.getWord()));
        ArrayList<StringBuilder> words = new ArrayList<>();
        ArrayList<Integer> instructions = new ArrayList<>();

        for(int i = 0; i < numOfWords; i++) {
            String input = io.getWord();
            words.add(new StringBuilder(input));
        }

        for(int j = 0; j < numOfWords - 1; j++) {
            int aString = io.getInt();
            int bString = io.getInt();
            
            if(!instructions.contains(aString)) {
                instructions.add(aString - 1);
            }
            if(!instructions.contains(bString)) {
                instructions.add(bString -1);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int k = 0; k < instructions.size(); k++) {
            result.append(words.get(instructions.get(k)));
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(result.toString() + " and it took " + elapsedTime/1000000 + " milliseconds");
        io.flush();
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
	    super(new BufferedOutputStream(System.out));
	    r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
	    super(new BufferedOutputStream(o));
	    r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
	    return peekToken() != null;
    }

    public int getInt() {
	    return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
	    return Double.parseDouble(nextToken());
    }

    public long getLong() {
	    return Long.parseLong(nextToken());
    }

    public String getWord() {
	    return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
	if (token == null) 
	    try {
		while (st == null || !st.hasMoreTokens()) {
		    line = r.readLine();
		    if (line == null) return null;
		    st = new StringTokenizer(line);
		}
		token = st.nextToken();
	    } catch (IOException e) { }
	    return token;
    }

    private String nextToken() {
	    String ans = peekToken();
	    token = null;
	    return ans;
    }
}
        Scanner s = new Scanner(System.in);
        int numOfWords = Integer.parseInt((s.nextLine()));

        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < numOfWords; i++) {
            String input = s.nextLine();
            words.add(input);
        }

        for(int j = 0; j < numOfWords - 1; j++) {
            StringBuilder result = new StringBuilder();
            int aString = s.nextInt();
            int bString = s.nextInt();
            result.append(words.get(aString - 1));
            result.append(words.get(bString - 1));

            words.set(aString - 1, result.toString());
            words.set(bString - 1, "");
        }
    
        for(int k = 0; k < words.size(); k++) {
            if(words.get(k) != "") {
                System.out.println(words.get(k));
            }
        }
    }
}
