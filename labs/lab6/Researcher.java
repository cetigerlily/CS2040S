public class Researcher implements Comparable<Researcher> {
    private int arrivalTime;
    private int workTime;

    public Researcher(int arrivalTime, int workTime) {
        this.arrivalTime = arrivalTime;
        this.workTime = workTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    @Override
    public int compareTo(Researcher other) {
        return this.getArrivalTime() - other.getArrivalTime(); // ranking them based on the arrivalTime
    }

    @Override
    public String toString() {
        String output = "[" + String.valueOf(arrivalTime) + ", " + String.valueOf(workTime) + "]";
        return output;
    }
}
