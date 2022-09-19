package q1;
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

        for(int i = 0; i < numOfWords; i++) {
            String input = io.getWord();
            words.add(new StringBuilder(input));
        }

        int tracker = 0;
        for(int j = 0; j < numOfWords - 1; j++) {
            int aString = io.getInt();
            int bString = io.getInt();
            
            words.get(aString - 1).append(words.get(bString - 1));
            tracker = aString - 1;
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(words.get(tracker).toString() + " and it took " + elapsedTime/1000000 + " milliseconds");
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
