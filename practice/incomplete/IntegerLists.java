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

            LinkedList<Integer> queue = new LinkedList<>();
            for(int j = 0; j < numOfElements; j++) {
                queue.addLast(Integer.parseInt(elements[j]));
            }

            boolean hasResult = true;
            for(int j = 0; j < commands.length; j++) {
                String currCommand = commands[j];
                if(currCommand.equals("R")) {
                    Collections.reverse(queue);
                }

                if(currCommand.equals("D")) {
                    if(queue.isEmpty()) {
                        hasResult = false;
                        break;
                    } else {
                        queue.removeFirst();
                    }
                }
            }

            if(hasResult) {
                String result = queue.toString().replaceAll("\\s", "");
                io.println(result);
            } else {
                io.println("error");
            }
        }
        io.flush();
        io.close();
    }
}
