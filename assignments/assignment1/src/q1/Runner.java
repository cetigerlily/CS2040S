package q1;

import java.util.*;
import java.lang.*;

public class Runner implements Comparable<Runner> {
    private String name;
    private double firstTime;
    private double secondTime;

    public Runner(String name, double firstTime, double secondTime) { 
        this.name = name;
        this.firstTime = firstTime;
        this.secondTime = secondTime;
    }

    public String getName() {
        return this.name;
    }

    public double getFirstTime() {
        return this.firstTime; 
    }

    public double getSecondTime() {
        return this.secondTime;
    }

    @Override
    public int compareTo(Runner runner) {
        if (this.secondTime > runner.secondTime) {
            return 1;
        } else if (this.getSecondTime() < runner.getSecondTime()) {
            return -1;
        } else {
            return 0;
        }
    }
}