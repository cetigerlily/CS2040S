import java.util.*;

public class FerryLoading {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            int ferryLength = io.getInt() * 100;
            int numOfCars = io.getInt();

            Queue<Integer> leftBank = new LinkedList<>();
            Queue<Integer> rightBank = new LinkedList<>();

            for(int j = 0; j < numOfCars; j++) {
                int carLength = io.getInt();
                String side = io.getWord();

                if(side.equals("left")) {
                    leftBank.add(carLength);
                } else if(side.equals("right")) {
                    rightBank.add(carLength);
                }
            }

            boolean ferryOnLeft = true; // initially starts on left side
            int numOfTrips = 0;

            while(!leftBank.isEmpty() || !rightBank.isEmpty()) {
                if(ferryOnLeft) {
                    int sumOfCars = 0;
                    while(!leftBank.isEmpty()) {
                        if(sumOfCars + leftBank.peek() <= ferryLength) {
                            int thisCar = leftBank.poll();
                            sumOfCars += thisCar;
                        } else {
                            break;
                        }
                    }
                    numOfTrips += 1;
                    ferryOnLeft = false;
                } else if(!ferryOnLeft) {
                    int sumOfCars = 0;
                    while(!rightBank.isEmpty()) {
                        if(sumOfCars + rightBank.peek() <= ferryLength) {
                            int thisCar = rightBank.poll();
                            sumOfCars += thisCar;
                        } else {
                            break;
                        }
                    }
                    numOfTrips += 1;
                    ferryOnLeft = true;
                }
            }
            io.println(numOfTrips);
        }
        io.flush();
        io.close();
    }
}
