public class Ladder implements Comparable<Ladder> { // edge
    private CoinStack start;
    private CoinStack end;
    private int length;
    
    public Ladder(CoinStack start, CoinStack end) {
        this.length = Math.max(0, end.getHeight() - start.getHeight());
        this.start = start;
        this.end = end;
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
