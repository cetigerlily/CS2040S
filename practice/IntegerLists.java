import java.util.*;

public class IntegerLists {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfTestCases = io.getInt();

        for(int i = 0; i < numOfTestCases; i++) {
            String[] commands = io.getWord().split("");
            int numOfElements = io.getInt();

            String temp = io.getWord();
            String[] elements;

            if(temp.length() > 2) {
                elements = temp.substring(1, temp.length() - 1).split(",");
            } else {
                elements = new String[0];
            }

            LinkedList<Integer> deque = new LinkedList<>();
            for(int j = 0; j < numOfElements; j++) {
                deque.addLast(Integer.parseInt(elements[j]));
            }

            boolean isReversed = false;
            boolean hasResult = true; // becomes false when it's empty

            for(int j = 0; j < commands.length; j++) {
                String currCommand = commands[j];
                if(currCommand.equals("R")) {
                    isReversed = !isReversed;
                }

                if(currCommand.equals("D")) {
                    if(deque.isEmpty()) {
                        hasResult = false;
                        break;
                    } else {
                        if(isReversed) {
                            deque.removeLast();
                        } else if (!isReversed) {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if(hasResult) {
                if(isReversed) {
                    Collections.reverse(deque);
                }
                String result = deque.toString().replaceAll("\\s", "");
                io.println(result);
            } else {
                io.println("error");
            }
        }
        io.flush();
        io.close();
    }
}
