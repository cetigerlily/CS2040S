package q1;
/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Instruction {
    private int index;
    private Instruction nextInstruction;
    private Instruction lastInstruction;

    public Instruction(int index) {
        this.index = index;
        this.nextInstruction = null; 
        this.lastInstruction = null; /* added as a tracker, in order to prevent setNextInstruction from being O(n) */
    }


    public int getIndex() {
        return this.index;
    }

    public Instruction getNextInstruction() {
        return this.nextInstruction;
    }

    public void setNextInstruction(Instruction nextInstruction) {
        if(this.getNextInstruction() == null) {
            this.nextInstruction = nextInstruction;
            this.lastInstruction = nextInstruction;
        } else if (this.getNextInstruction() != null) {
            this.lastInstruction.setNextInstruction(nextInstruction); /* have to apply setNextInstr on the last instruction in case it has next instructions when added later */
            this.lastInstruction = nextInstruction;
        }
    }
}
