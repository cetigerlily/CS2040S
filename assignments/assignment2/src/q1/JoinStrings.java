package q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;

public class JoinStrings {
    public static void main(String[] args) throws Exception {
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
