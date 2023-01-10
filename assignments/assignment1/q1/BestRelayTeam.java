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
        ArrayList<Runner> allRunners = new ArrayList<>();
        ArrayList<Runner> bestTeam = new ArrayList<>();
    
        for(int i = 0; i < numOfRunners; i++) {
            String input = s.nextLine();
            String[] runnerInfo = input.split(" ");
            allRunners.add(new Runner(runnerInfo[0], Double.parseDouble(runnerInfo[1]), Double.parseDouble(runnerInfo[2])));
        }

        Collections.sort(allRunners); /* sorting the runners based on their second times */

        double testTime = 0;
        double bestTime = 100;

        for(int i = 0; i < numOfRunners; i++) {
            ArrayList<Runner> testTeam = new ArrayList<>();
            testTeam.add(allRunners.get(i));
            testTime = allRunners.get(i).getFirstTime();

            for(int j = 0; testTeam.size() < 4; j++) {
                if(j != i) {
                    testTeam.add(allRunners.get(j));
                    testTime += allRunners.get(j).getSecondTime();
                }
            }

            if(testTime < bestTime) {
                bestTeam = testTeam;
                bestTime = testTime;
            }
        }

        System.out.println(bestTime);
        for(int i = 0; i < 4; i++) {
            System.out.println(bestTeam.get(i).getName());
        }
    }
}
