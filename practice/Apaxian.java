import java.util.*;
import java.lang.*;

public class Apaxian {
    static ArrayList<String> compactName = new ArrayList<>();

    public static String compact(String name) {
        StringBuilder compactName = new StringBuilder();
        compactName.append(name.charAt(0));

        for(int i = 1; i < name.length(); i++) {
            char curr = name.charAt(i);
            char prev = name.charAt(i - 1);

            if(curr != prev) {
                compactName.append(curr);
            }
        }
        return compactName.toString();
    }
        
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();

        System.out.println(compact(name));
    }
}
