public class CoinStack { // vertex
    private int m;
    private int n;
    private int height;

    public CoinStack(int m, int n) {
        this.m = m;
        this.n = n;
        this.height = MillionaireMadness.coinStackHeight[this.getM()][this.getN()];
    }

    public int getM() {
        return this.m;
    }

    public int getN() {
        return this.n;
    }

    public int getHeight() {
        return this.height;
    }
}
