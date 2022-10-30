import java.util.*;
import java.io.*;

public class CoinStack implements Comparable<CoinStack> {
    private int x;
    private int y;
    private int height;

    public CoinStack(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int compareTo(CoinStack other) {
        return this.getHeight() - other.getHeight();
    }
}
