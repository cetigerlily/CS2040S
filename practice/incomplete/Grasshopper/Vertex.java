import java.awt.*;

public class Vertex {
    private Point point;
    private int distance;

    public Vertex(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }

    public Point getPoint() {
        return this.point;
    }

    public int getDistance() {
        return this.distance;
    }
}
