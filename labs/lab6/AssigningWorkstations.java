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

            while(!(workstationQ.isEmpty())) {
                if(thisResearcher.getArrivalTime() <= workstationQ.peek().getLockTime()) {
                    if((workstationQ.peek().getLockTime() - m) <= thisResearcher.getArrivalTime()) { // can use the WS because the researcher arrived after avail time
                        workstationQ.poll();
                    } else {
                        unlocked++;
                    }
                    Workstation newWorkstation = new Workstation(thisResearcher.getAvailableTime() + m);
                    workstationQ.add(newWorkstation);
                    break; // since found an existing WS or unlocked a new WS for the researcher, can break
                } else if(thisResearcher.getArrivalTime() > workstationQ.peek().getLockTime()) { // can't use exiting WS if researcher arrives after lock time)
                    workstationQ.poll();
                }
            }

            if(workstationQ.isEmpty()) {
                Workstation newWorkstation = new Workstation(thisResearcher.getAvailableTime() + m);
                workstationQ.add(newWorkstation);
                unlocked++;
            }

        }
        io.println(numOfResearchers - unlocked);
        io.flush();
    }
}
