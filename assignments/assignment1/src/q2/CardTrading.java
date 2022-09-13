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

        String secondInput = s.nextLine();
        String[] deck = secondInput.split(" ");

        /*  an array which holds the information of card types in the deck */
        ArrayList<Card> cardInfo = new ArrayList<>();

        for(int t = 0; t < numOfTypes; t++) {
            int buyPrice = s.nextInt();
            int sellPrice = s.nextInt();
            cardInfo.add(new Card(t + 1, buyPrice, sellPrice));        
        }

        for(int n = 0; n < numOfCards; n++) {
            int temp = Integer.parseInt(deck[n]);
            cardInfo.get(temp - 1).updateRepeats();
        }

        Collections.sort(cardInfo);

        long profit = 0;
        
        /* make a pair from the first k cards - subtract the cost from the profit */
        for(int k = 0; k < numOfCombos; k++) {
            profit -= cardInfo.get(k).getBuyPrice();
        }

        /* sell the rest of the remaining cards in the deck */
        if(numOfTypes > numOfCombos) {
            for(int i = numOfCombos; i < numOfTypes; i++) {
                profit += cardInfo.get(i).getSellPrice();
            }
        }
        System.out.println(profit);
    }
}
