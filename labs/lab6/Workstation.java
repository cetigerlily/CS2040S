public class Workstation implements Comparable<Workstation> {
    private int lockTime;

    public Workstation(int lockTime) {
        this.lockTime = lockTime;
    }

    public int getLockTime() {
        return lockTime;
    }

    @Override
    public int compareTo(Workstation other) {
        return this.getLockTime() - other.getLockTime();
    }

    @Override
    public String toString() {
        String output = String.valueOf(lockTime);
        return output;
    }
}
