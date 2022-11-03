import java.util.*;

/* PSEUDO-CODE: Prim's algorithm is needed for this problem
 * 1) Start at the first village, add its road to a priority queue of roads (rank roads based on length)
 * 2) Add the first village's roads to the pq
 * 3) While pq is not empty, get next shortest road and add it to the MST if the end village is not in the MST yet - enqueue the end village's roads + print
 */

public class LostMap {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfVillages = io.getInt();

        boolean[] addedTo = new boolean[numOfVillages]; // if villages have been added to the MST or not
        HashMap<Integer, ArrayList<Road>> villageGrid = new HashMap<>(); // <village id, list of it's connected roads (roads going out from)>

        for(int i = 0; i < numOfVillages; i++) { // for each village
            addedTo[i] = false;
            for(int j = 0; j < numOfVillages; j++) { // for each road in a village
                if(!villageGrid.containsKey(i)) {
                    villageGrid.put(i, new ArrayList<>());
                }
                villageGrid.get(i).add(new Road(i, j, io.getInt()));
            }
        }

        PriorityQueue<Road> queueOfRoads = new PriorityQueue<>();
        queueOfRoads.addAll(villageGrid.get(0)); // add village 0's children to the queue of roads
        addedTo[0] = true;

        while(!queueOfRoads.isEmpty()) {
            Road minRoad = queueOfRoads.poll();
            if(!addedTo[minRoad.getEnd()]) {
                addedTo[minRoad.getEnd()] = true;

                int start = minRoad.getStart() + 1;
                int end = minRoad.getEnd() + 1;
                io.println(start + " " + end);

                queueOfRoads.addAll(villageGrid.get(end - 1));
            }
        }
        io.flush();
    }
}   
