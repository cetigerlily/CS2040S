/**
 * Celeste Tigerlily Cheah Kae
 * A0245928R
 */

import java.util.*;
import java.lang.*;

public class PlayerHands {
    private int id; 
    private int status;
    /* 0 = fold, 1 = fist, 2 = palm down */

    public PlayerHands(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void updateStatus() {
        this.status += 1;
    }

    public int getStatus() {
        return this.status;
    }
}