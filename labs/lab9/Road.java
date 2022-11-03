public class Road implements Comparable<Road> {
    private int start;
    private int end;
    private int length;

    public Road(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public int compareTo(Road other) {
        return this.getLength() - other.getLength();
    }

    @Override
    public String toString() {
        String result = this.getStart() + " " + this.getEnd();
        return result;
    }
}
