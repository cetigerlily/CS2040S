package q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
public class BestRelayTeam {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numOfRunners = Integer.parseInt(s.nextLine());
        Runner[] allRunners = new Runner[numOfRunners];
        Runner[] trialTeam = new Runner[4];
        Runner[] bestTeam = new Runner[4];

        for(int i = 0; i < numOfRunners; i++) {
            String input = s.nextLine();
            String[] runnerInfo = input.split(" ");
            Runner currRunner = new Runner(runnerInfo[0], 
                Double.parseDouble(runnerInfo[1]), Double.parseDouble(runnerInfo[2]));
            allRunners[i] = currRunner;
        }

        Arrays.sort(allRunners);
      
        Runner bestFirst = allRunners[numOfRunners - 1];
        for(int i = 4; i < numOfRunners; i++) {
            if(bestFirst.getFirstTime() > allRunners[i].getFirstTime()) {
                bestFirst = allRunners[i];
            }
        }

        bestTeam[0] = bestFirst;
        bestTeam[1] = allRunners[0];
        bestTeam[2] = allRunners[1];
        bestTeam[3] = allRunners[2];

        double totalTime = bestTeam[0].getFirstTime() + bestTeam[1].getSecondTime() 
            + bestTeam[2].getSecondTime() + bestTeam[3].getSecondTime();

        System.out.println(totalTime);
        for(int i = 0; i < 4; i++) {
            System.out.println(bestTeam[i].getName());
        }
    }
}
// choosing the fastest 3 in second time doesn't always result in the fastest team