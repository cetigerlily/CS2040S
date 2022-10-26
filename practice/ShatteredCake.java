public class ShatteredCake {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int width = io.getInt();
        int numOfPieces = io.getInt();

        int areaCake = 0;
        for(int i = 0; i < numOfPieces; i++) {
            int pieceWidth = io.getInt();
            int pieceLength = io.getInt();

            areaCake += pieceWidth * pieceLength;
        }

        int length = areaCake / width;
        io.println(length);
        io.flush();
    }
}
