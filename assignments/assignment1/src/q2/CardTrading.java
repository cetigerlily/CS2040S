package q2;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;

public class CardTrading {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstInput = s.nextLine();
        String[] numInfo = firstInput.split(" ");

        int numOfCards = Integer.parseInt(numInfo[0]);
        int numOfTypes = Integer.parseInt(numInfo[1]);
        int numOfCombos = Integer.parseInt(numInfo[2]);

        ArrayList<Card> deck = new ArrayList<>();

        String secondInput = s.nextLine();
        String[] deckInfo = secondInput.split(" ");

        /* first intialize the deck with the proper buy/sell info */
        for(int i = 0; i < numOfTypes; i++) {
            String input = s.nextLine();
            String[] cardPriceInfo = input.split(" ");

            deck.add(new Card(0 /* simply put a value for now */, Integer.parseInt(cardPriceInfo[0]), Integer.parseInt(cardPriceInfo[1])));
        }
        
        for(int i = 0; i < numOfCards; i++) {
            for(int j = 0; j < numOfCards; j++) {
                if(Integer.parseInt(deckInfo[i]) == deck.get(j).getValue()) {
                    deck.add(deck.get(j));
                    deck.get(j).updateRepeats();
                } else {
                    break;
                }
            }
            deck.get(i).updateNumber(Integer.parseInt(deckInfo[i]));
        }
        System.out.println(deck);
    }
}
