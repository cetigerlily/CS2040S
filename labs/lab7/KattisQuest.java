/**
 PSEUDO-CODE:
 1) Initialize a TreeSet which holds items of a custom class, Quest(E, G) - sorted by the E, and then sorted by G if the E values are equal
 2) For N, if command = add:
    a) Make a new Quest(E, G) and add it to the TreeSet
 3) else if command = query: 
    a) Initialize a long sumOfGold
    b) Find largest element in TreeSet which is smaller or equal to E using floor()
    c) X -= E; and sumOfGold += G
    d) Continue as long as X > 0 and if an element is found
    e) Print out the sumOfGold

while(Quest with E less than or equal to X is found) {
    
}
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class KattisQuest {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        long numOfCommands = io.getLong();
        TreeSet<Quest> quests = new TreeSet<>();

        for(long i = 0; i < numOfCommands; i++) {
            String command = io.getWord();

            if(command.equals("add")) {
                long energy = io.getLong();
                long gold = io.getLong();

                Quest newQuest = new Quest(energy, gold, i);
                quests.add(newQuest);
            } else if(command.equals("query")) {
                long availableEnergy = io.getLong();
                long sumOfGold = 0;

                while(availableEnergy > 0) {
                    Quest comparingQuest = new Quest(availableEnergy, 1000000, 0);
                    Quest foundQuest = quests.floor(comparingQuest);
                    if(foundQuest != null) {
                        availableEnergy -= foundQuest.getEnergy();
                        sumOfGold += foundQuest.getGold();
                        quests.remove(foundQuest);
                    } else {
                        break;
                    }
                }
                io.println(sumOfGold);

            }
        }
        io.flush();
    }
}
