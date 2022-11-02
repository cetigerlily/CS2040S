public class Vertex {
    private int r;
    private int c;
    private int distance;

    public Vertex(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }

    public int getR() {
        return this.r;
    }

    public int getC() {
        return this.c;
    }

    public int getDistance() {
        return this.distance;
    }
}
