/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int n = s.nextInt();

        int[] values = new int[n];
        for(int i = 0; i < n; i++) {
            values[i] = i + 1;
        }
    
        String[] result = new String[n];
        for(int j = 0; j < values.length; j++) {
            int currentElement = values[j];
            if(currentElement % x == 0 && currentElement % y == 0) {
                result[j] = "FizzBuzz";
            } else if(currentElement % x == 0) {
                result[j] = "Fizz";
            } else if (currentElement % y == 0) {
                result[j] = "Buzz";
            } else {
                result[j] = String.valueOf(currentElement);
            }
        }

        for(int k = 0; k < result.length; k++) {
            System.out.println(result[k]);
        }
    }
}