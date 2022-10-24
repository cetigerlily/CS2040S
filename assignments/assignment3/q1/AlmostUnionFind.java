package q1;
import java.util.*;

public class AlmostUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            long numOfInts = io.getLong();
            long numOfCommands = io.getLong();

            HashMap<Long, Long> parent = new HashMap<>(); // <int, parent>
            HashMap<Long, Long> size = new HashMap<>();
            HashMap<Long, Long> sum = new HashMap<>();

            for(long i = 1; i < numOfInts + 1; i++) {
                parent.put(i, i);
                size.put(i, (long) 1);
                sum.put(i, i);
            }

            for(int i = 0; i < numOfCommands; i++) { // after m lines, it will be the next test-case if there are more
                int command = io.getInt();
                if(command == 1) {
                    long p = io.getLong();
                    long q = io.getLong();

                    long parentP = parent.get(p);
                    long parentQ = parent.get(q);

                    if(parentP != parentQ) {
                        long tracker = size.get(parentP) - size.get(parentQ);
                        if(tracker >= 0) { // p > q, add q to p
                            size.put(parentP, size.get(parentP) + size.get(parentQ));
                            // size.put(parentQ, (long) 0);

                            sum.put(parentP, sum.get(parentP) + sum.get(parentQ));
                            // sum.put(parentQ, (long) 0);

                            parent.put(parentQ, parentP);
                        } else {
                            size.put(parentQ, size.get(parentQ) + size.get(parentP));
                            // size.put(parentP, (long) 0);

                            sum.put(parentQ, sum.get(parentQ) + sum.get(parentP));
                            // sum.put(parentP, (long) 0);

                            parent.put(parentP, parentQ);
                        }
                    }

                } else if(command == 2) { // move
                    long p = io.getLong();
                    long q = io.getLong();

                    long parentP = parent.get(p);
                    long parentQ = parent.get(q);
                    
                    if(parentP != parentQ) {
                        size.put(parentP, size.get(parentP) - 1);
                        size.put(parentQ, size.get(parentQ) + 1);
                        sum.put(parentP, sum.get(parentP) - p);
                        sum.put(parentQ, sum.get(parentQ) + p);

                        parent.put(p, parentQ);
                    }

                } else if(command == 3) { // numAndSum
                    long p = io.getLong();
                    long parentP = parent.get(p);

                    long numOfElements = size.get(parentP);
                    long sumOfElements = sum.get(parentP);

                    System.out.println(numOfElements + " " + sumOfElements);
                }
            }
        }
        io.flush();
    }
}
