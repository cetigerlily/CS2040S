import java.util.ArrayList;
import java.util.Scanner;

public class PeaSoup {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfRests = Integer.parseInt(s.nextLine());
        ArrayList<String> rests = new ArrayList<>();
 
        while(numberOfRests > 0) { 
            int numberOfItems = Integer.parseInt(s.nextLine());
            String restName = s.nextLine();

            boolean peaSoup = false;
            boolean pancakes = false;

            while(numberOfItems > 0) {
                String currentItem = s.nextLine();
                if(currentItem.equals("pea soup")) {
                    peaSoup = true;
                } else if (currentItem.equals("pancakes")) {
                    pancakes = true;
                }
                if(peaSoup && pancakes) {
                    rests.add(restName);
                    break;
                }
                numberOfItems--;
            }
            numberOfRests--;
        }

        if(rests.isEmpty()) {
            System.out.println("Anywhere is fine I guess");
        } else {
            System.out.println(rests.get(0));
        }
    }
}
