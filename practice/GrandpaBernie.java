/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class GrandpaBernie {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTrips = io.getInt();
        HashMap<String, ArrayList<Integer>> trips = new HashMap<>(); // <country name, list of years visited>

        for(int i = 0; i < numOfTrips; i++) {   
            String countryName = io.getWord();
            int year = io.getInt();

            if(trips.containsKey(countryName)) {
                trips.get(countryName).add(year);
            } else {
                ArrayList<Integer> yearsVisited = new ArrayList<>();
                yearsVisited.add(year);
                trips.put(countryName, yearsVisited);
            }
        }

        int numOfQueries = io.getInt();
        HashSet<String> queries = new HashSet<>();

        for(int j = 0; j < numOfQueries; j++) {
            String queryCountry = io.getWord();
            int k = io.getInt();

            if(queries.contains(queryCountry)) { // already sorted
                io.println(trips.get(queryCountry).get(k - 1));
            } else {
                Collections.sort(trips.get(queryCountry));
                io.println(trips.get(queryCountry).get(k - 1));
                queries.add(queryCountry);
            }
        }
        io.flush();
    }
}
