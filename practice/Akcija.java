import java.util.*;

public class Akcija {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfBooks = io.getInt();
        ArrayList<Integer> bookPrices = new ArrayList<>();

        for(int i = 0; i < numOfBooks; i++) {
            int thisBookPrice = io.getInt();
            bookPrices.add(thisBookPrice);
        }

        Collections.sort(bookPrices, Collections.reverseOrder());
        int minimumPrice = 0;
        for(int i = 0; i < numOfBooks; i++) {
            if((i + 1) % 3 != 0) { // non-discounted book
                minimumPrice += bookPrices.get(i);
            }
        }
        io.println(minimumPrice);
        io.flush();
    }
}
