import java.util.*;
import java.io.*;

public class TravelTheSkies {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfAirports = io.getInt();
        int numOfDays = io.getInt();
        int numOfFlights = io.getInt();

        HashMap<Integer, ArrayList<Flight>> flightsPerDay = new HashMap<>(); // all flights on a given day
        HashMap<Integer, ArrayList<Integer>> peoplePerDay = new HashMap<>(); // # of people per day at given airports - <airport id, list of people per day>

        for(int i = 0; i < numOfFlights; i++) {
            int origin = io.getInt() - 1;
            int destination = io.getInt() - 1; 
            int day = io.getInt() - 1;
            int capacity = io.getInt();

            Flight thisFlight = new Flight(origin, destination, capacity);

            if(!flightsPerDay.containsKey(day)) { // if haven't started a map for given day
                flightsPerDay.put(day, new ArrayList<>());
            }
            flightsPerDay.get(day).add(thisFlight);
        }

        for(int i = 0; i < numOfAirports * numOfDays; i++) {
            int airport = io.getInt() - 1;
            int day = io.getInt() - 1;
            int passengers = io.getInt(); // customers at the airport on day who want to fly

            if(!peoplePerDay.containsKey(airport)) {
                peoplePerDay.put(airport, new ArrayList<>());
            }
            peoplePerDay.get(airport).add(day, passengers);
        }

        boolean isOptimal = false;
        for(int i = 0; i < numOfDays; i++) {
            for(int j = 0; j < flightsPerDay.get(i).size(); j++) { // for each flight on day i
                Flight currentFlight = flightsPerDay.get(i).get(j);

                int origin = currentFlight.getOrigin();
                int destination = currentFlight.getDestination();

                int fullCapacity = currentFlight.getCapacity();
                int actualCapacity = 0;

                int currentDay = 0;
                // determine whether or not this flight can optimally fly based on people at airport
                while((fullCapacity >= actualCapacity) && (currentDay < numOfDays)) { // maximum 8 days
                    int totalPeople = peoplePerDay.get(origin).get(currentDay);

                    if(fullCapacity == actualCapacity) {
                        isOptimal = true;
                        break;
                    }

                    if(totalPeople <= (fullCapacity - actualCapacity)) {
                        actualCapacity += totalPeople;
                        peoplePerDay.get(origin).add(currentDay, 0); // set the current day to 0 now since put everyone on the flight
                    } else if(totalPeople > (fullCapacity - actualCapacity)) {
                        int difference = totalPeople - (fullCapacity - actualCapacity);
                        actualCapacity += difference;
                        peoplePerDay.get(origin).add(currentDay, peoplePerDay.get(origin).get(currentDay) - difference); // update the value, not everyone got on the flight
                    }
                    currentDay += 1;
                }

                if(isOptimal) { // if can fly optimally, update people values
                    peoplePerDay.get(destination).add(i + 1, peoplePerDay.get(destination).get(i) + currentFlight.getCapacity()); // adding existing value of people to the new flown in people
                } else if(!isOptimal) {
                    // end the simulation
                    break;
                }
            }
        }

        if(isOptimal) {
            io.println("optimal");
        } else {
            io.println("suboptimal");
        }
        io.flush();
    }
}

class Flight {
    private int origin;
    private int destination;
    private int capacity;

    public Flight(int origin, int destination, int capacity) {
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }

    public int getOrigin() {
        return this.origin;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getCapacity() {
        return this.capacity;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
    if (token == null) 
        try {
        while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        token = st.nextToken();
        } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
