/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class Conformity {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfFrosh = Integer.parseInt((io.getWord()));
        HashMap<HashSet<Integer>, Integer> allCC = new HashMap<>(); // <frosh's CC, popularity = number of same CC>
        
        HashSet<Integer> mostPopularCC = new HashSet<>(); // CC which is the most popular
        int numOfPopularCC = 0; // number of CC which are equally popular

        for(int i = 0; i < numOfFrosh; i++) {
            HashSet<Integer> thisFrosh = new HashSet<>();
            for(int j = 0; j < 5; j++) {
                thisFrosh.add(io.getInt());
                if(j == 0) {
                    mostPopularCC = thisFrosh; // initialize first CC to be the most popular
                }
            }

            if(allCC.containsKey(thisFrosh)) {
                allCC.put(thisFrosh, allCC.get(thisFrosh) + 1);

                if(allCC.get(mostPopularCC) < allCC.get(thisFrosh)) { // if popularity of most popular CC < popularity of this frosh
                    mostPopularCC = thisFrosh;
                    numOfPopularCC = 1;
                } else if (allCC.get(mostPopularCC) == allCC.get(thisFrosh)) { // have the same popularities
                    numOfPopularCC += 1;
                }

            } else {
                allCC.put(thisFrosh, 1);
            }
        }

        if(numOfPopularCC == 0) { // all CC have popularity of 1
            io.println(numOfFrosh);
        } else if(numOfPopularCC == 1) { // one CC is the most popular
            io.println(allCC.get(mostPopularCC));
        } else { // when numOfPopularCC > 1, could either be n different popular CCs or all of the CCs are the same
            int maxPopularity = Collections.max(allCC.values());
            int frequency = Collections.frequency(allCC.values(), maxPopularity);
            io.println(maxPopularity * frequency);
        }
        
        io.flush();
    }   
}
