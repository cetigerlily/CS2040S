import java.util.*;

public class AssigningWorkstations {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        int numOfResearchers = io.getInt();
        int m = io.getInt();
        int unlocked = 0;
        
        PriorityQueue<Researcher> researcherQ = new PriorityQueue<>();
        PriorityQueue<Workstation> workstationQ = new PriorityQueue<>();

        for(int i = 0; i < numOfResearchers; i++) {
            int arrivalTime = io.getInt();
            int workTime = io.getInt();
            researcherQ.add(new Researcher(arrivalTime, workTime));
        }

        for(int j = 0; j < numOfResearchers; j++) {
            Researcher thisResearcher = researcherQ.poll();
 
            if(workstationQ.isEmpty()) {
                Workstation newWorkstation = new Workstation(thisResearcher.getArrivalTime() + thisResearcher.getWorkTime() + m);
                workstationQ.add(newWorkstation);
                unlocked++;
            } else if(!(workstationQ.isEmpty())) {
                if(workstationQ.peek().getLockTime() - m <= thisResearcher.getArrivalTime()) { // if it's available before researcher arrives
                    workstationQ.poll();
                    workstationQ.add(new Workstation(thisResearcher.getArrivalTime() + thisResearcher.getWorkTime() + m));
                    
                } else if(workstationQ.peek().getLockTime() - m > thisResearcher.getArrivalTime()) {
                    Workstation newWorkstation = new Workstation(thisResearcher.getArrivalTime() + thisResearcher.getWorkTime() + m);
                    workstationQ.add(newWorkstation);
                    unlocked++;
                }
            } 
        }
        io.println(numOfResearchers - unlocked);
        io.flush();
    }
}
