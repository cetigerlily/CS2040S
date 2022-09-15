/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;

class FirstTwoComparator implements Comparator<String> {
    @Override
    public int compare(String n1, String n2) {
        int firstN1 = n1.charAt(0);
        int firstN2 = n2.charAt(0);

         if(firstN1 - firstN2 == 0) {
            int secondN1 = n1.charAt(1);
            int secondN2 = n2.charAt(1);
            return secondN1 - secondN2;
        } else {
            return firstN1 - firstN2;
        }
    }
}

public class SortOfSorting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            int numOfNames = Integer.parseInt(s.nextLine());
            if(numOfNames == 0) {
                break;
            } 

            String[] names = new String[numOfNames];
            for(int i = 0; i < numOfNames; i++) {
                String currentName = s.nextLine();
                names[i] = currentName;
            }
    
            Arrays.sort(names, new FirstTwoComparator());
            for(int i = 0; i < numOfNames; i++) {
                if(i == numOfNames - 1) {
                    System.out.println(names[i] + "\n");
                } else {
                    System.out.println(names[i]);
                }
            }
        }
    }
}