/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.Scanner;

public class t9spelling {
    public static void main(String[] args) {
        String[] number = new String[]{"2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999", "0"};
        Scanner s = new Scanner(System.in);
        int numOfCases = Integer.parseInt(s.nextLine());

        for(int c = 1; c <= numOfCases; c++) {
            String w = s.nextLine();
            char[] word = w.toCharArray();
            StringBuilder result = new StringBuilder();

            for(int i = 0; i < word.length; i++) { 
                int index = word[i] - 'a';
                if(index < 0) {
                    if((result.length() != 0) && (result.charAt(result.length() - 1) == number[26].charAt(0))) {
                        result.append(" ");
                    }
                    result.append(number[26]);
                }
                if (index >= 0) {
                    if((result.length() != 0) && (result.charAt(result.length() - 1) == number[index].charAt(0))) {
                        result.append(" ");
                    }
                    result.append(number[index]);
                }
            } 
            System.out.println("Case #" + c + ": " + result);
        }
    }
}