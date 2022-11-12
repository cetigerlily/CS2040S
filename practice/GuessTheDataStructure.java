import java.util.*;

public class GuessTheDataStructure {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        while(io.hasMoreTokens()) {
            int numOfCommands = io.getInt();

            ArrayList<Command> commands = new ArrayList<>();
            for(int i = 0; i < numOfCommands; i++) {
                commands.add(new Command(io.getInt(), io.getInt()));
            }

            boolean[] result = {checkStack(commands), checkQueue(commands), checkPriorityQueue(commands)};
            int count = 0;
            for(int i = 0; i < result.length; i++) {
                if(result[i]) {
                    count += 1;
                }
            }

            if(count == 0) {
                io.println("impossible");
            } else if(count > 1) {
                io.println("not sure");
            } else if(count == 1) {
                if(result[0]) {
                    io.println("stack");
                } else if(result[1]) {
                    io.println("queue");
                } else if(result[2]) {
                    io.println("priority queue");
                }
            }
        }   
        io.flush();
    }

    public static boolean checkStack(ArrayList<Command> commands) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < commands.size(); i++) {
            int type = commands.get(i).getType();

            if(type == 1) {
                int input = commands.get(i).getValue();
                stack.push(input);
            } else if(type == 2) {
                int output = commands.get(i).getValue();
                try {
                    int actual = stack.pop();
                    if(actual != output) {
                        return false;
                    }
                } catch (EmptyStackException error) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkQueue(ArrayList<Command> commands) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < commands.size(); i++) {
            int type = commands.get(i).getType();

            if(type == 1) {
                int input = commands.get(i).getValue();
                queue.add(input);
            } else if(type == 2) {
                int output = commands.get(i).getValue();
                try {
                    int actual = queue.remove();
                    if(actual != output) {
                        return false;
                    }
                } catch (NoSuchElementException error) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkPriorityQueue(ArrayList<Command> commands) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < commands.size(); i++) {
            int type = commands.get(i).getType();

            if(type == 1) {
                int input = commands.get(i).getValue();
                pq.add(input);
            } else if(type == 2) {
                int output = commands.get(i).getValue();
                try {
                    int actual = pq.remove();
                    if(actual != output) {
                        return false;
                    }
                } catch (NoSuchElementException error) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Command {
    private int type; // 1 or 2
    private int value; // output or input

    public Command(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }
}
