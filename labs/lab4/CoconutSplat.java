/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;

public class CoconutSplat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] nums = input.split(" ");

        int numOfSyllables = Integer.parseInt(nums[0]);
        int numOfPlayers = Integer.parseInt(nums[1]);

        ArrayList<PlayerHands> players = new ArrayList<>();
        
        int count = 0;
        while(count < numOfPlayers) {
            players.add(new PlayerHands(count, 0));
            count += 1;
        }

        PlayerHands currentPlayer;
        int landedPosition = 0; /* counting begins at 0 */

        /* repeat until only one player/hand left */
        while(players.size() > 1) {
            landedPosition = (landedPosition + numOfSyllables - 1) % players.size(); 
            currentPlayer = players.get(landedPosition);
    
            if(currentPlayer.getStatus() == 0) {
                currentPlayer.updateStatus();
                players.add(landedPosition + 1, new PlayerHands(currentPlayer.getId(), currentPlayer.getStatus()));
            } else if (currentPlayer.getStatus() == 1) {
                currentPlayer.updateStatus();
                landedPosition += 1; /* have to add in order to move the starting point to the next "hand" */
            } else if (currentPlayer.getStatus() == 2) { /* if it is a behind back status, remove it from the array */
                players.remove(landedPosition);
            }
        }
        System.out.println(players.get(0).getId() + 1);
    }
}