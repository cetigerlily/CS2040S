public class SumKindOfProblem {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int P = io.getInt();

        for(int i = 0; i < P; i++) {
            int K = io.getInt();
            int N = io.getInt();

            long S1 = 0;
            long S2 = 0; // odd
            long S3 = 0; // even

            for(int j = 1; j <= 2 * N; j++) {
                if(j < N + 1) {
                    S1 += j;
                }

                if(j % 2 == 0) {
                    S3 += j;
                }
                
                if(j % 2 == 1) {
                    S2 += j;
                }
            }
            io.println(K + " " + S1 + " " + S2 + " " + S3);
        }
        io.flush();
    }
}
