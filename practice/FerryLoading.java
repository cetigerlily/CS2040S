import java.util.*;

public class FerryLoading {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            int lengthFerry = io.getInt() * 100; // converting m to cm for length
            int numOfCars = io.getInt();

            Stack<Integer> leftBank = new Stack<>();
            Stack<Integer> rightBank = new Stack<>();

            for(int j = 0; j < numOfCars; j++) {
                int lengthCar = io.getInt();
                String side = io.getWord();
                if(side.equals("left")) {
                    leftBank.push(lengthCar);
                } else if(side.equals("right")) {
                    rightBank.push(lengthCar);
                }
            }

            int currentBank = 0;
            int lengthCarSum = 0;
            int moves = 0;

            for(int j = 0; j < numOfCars; j++) {
                if(currentBank == 0) {
                    while(lengthCarSum <= lengthFerry && !leftBank.empty()) {
                        if(leftBank.peek() + lengthCarSum <= lengthFerry) { // continue adding until full
                            lengthCarSum += leftBank.pop();
                        } else if(leftBank.peek() + lengthCarSum > lengthFerry) { // move when full
                            break;
                        }
                    }
                    
                    if(lengthCarSum > 0 || !rightBank.empty()) {
                        currentBank = 1;
                        moves += 1;
                    } else {
                        break;
                    }
                } else if(currentBank == 1) {
                    while(lengthCarSum <= lengthFerry && !rightBank.empty()) {
                        if(rightBank.peek() + lengthCarSum <= lengthFerry) { // continue adding until full
                            lengthCarSum += rightBank.pop();
                        } else if(rightBank.peek() + lengthCarSum > lengthFerry) { // move when full
                            break;
                        }
                    }

                    if(lengthCarSum > 0 || !leftBank.empty()) {
                        currentBank = 0;
                        moves += 1;
                    } else {
                        break;
                    }
                }
            }
            io.println(moves);
        }
        io.flush();
    }
}
