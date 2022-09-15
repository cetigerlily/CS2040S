/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;

public class Autori {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String fullNames = s.nextLine();
        String[] splitFullNames = fullNames.split("-");

        String abbreviation = "";
        for(int i = 0; i < splitFullNames.length; i++) {
            abbreviation += splitFullNames[i].charAt(0);
        }
        System.out.println(abbreviation);
    }
}