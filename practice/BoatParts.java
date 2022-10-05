package week7;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class BoatParts {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfBoatParts = io.getInt();
        int numOfDays = io.getInt();
        HashMap<String, Integer> replacedItems = new HashMap<>(); // <boat part, day added>

        int counter = 0; // count of unique items replaced

        for(int i = 0; i < numOfDays; i++) {
            String boatPart = io.getWord();
            if(!(replacedItems.containsKey(boatPart))) { // a new boat part
                replacedItems.put(boatPart, i + 1);
                counter++;
            
                if(counter == numOfBoatParts) {
                    io.println(i + 1);
                    break;
                }
            }
        }
        
        if(counter != numOfBoatParts) {
            io.println("paradox avoided");
        }
        io.flush();
    }
}
