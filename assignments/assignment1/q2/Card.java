package q2;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;

public class Card implements Comparable<Card> {
    private int number;
    private int buyPrice;
    private int sellPrice;
    private int repeats;

    public Card(int number, int buyPrice, int sellPrice) {
        this.number = number;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
    
    public int getBuyPrice() {
        /* the price of buying is how many more cards is needed to make a combo * buy price */
        int numOfNeeded = 2 - this.getRepeats(); /* because you need only at least 2 */
        return numOfNeeded * this.buyPrice;
    }

    public int getSellPrice() {
        /* the price of selling/profit is how many cards there are * sell price */
        return this.getRepeats() * this.sellPrice;
    }

    public int getCost() {
        return this.getBuyPrice() + this.getSellPrice();
    }

    public int getRepeats() {
        return repeats;
    }

    public void updateRepeats() {
        repeats += 1;
    }

    @Override
    public int compareTo(Card card) {
        if(this.getCost() > card.getCost()) {
            return 1;
        } else if (this.getCost() < card.getCost()) {
            return -1;
        } else {
            return 0;
        }
    }
}
