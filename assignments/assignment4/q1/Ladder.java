public class Ladder implements Comparable<Ladder> {
    private CoinStack start;
    private CoinStack end;
    private int length;

    public Ladder(CoinStack start, CoinStack end) {
        this.start = start;
        this.end = end;
        this.length = Integer.max(start.getHeight() - end.getHeight(), 0);
    }

    public int getLength() {
        return this.length;
    }

    public CoinStack getStart() {
        return this.start;
    }

    public CoinStack getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(Ladder other) {
        return this.getLength() - other.getLength();
    }
}
