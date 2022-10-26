public class ExactlyElectrical {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int a = io.getInt();
        int b = io.getInt();
        int c = io.getInt();
        int d = io.getInt();
        int t = io.getInt();

        int distanceBetween = Math.abs(a - c) + Math.abs(b - d);
        if((distanceBetween > t) || ((t - distanceBetween) % 2 == 1)) {
            io.println("N");
        } else {
            io.println("Y");
        }
        io.flush();
    }
}
