package SayisalAnaliz;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        double[] x = new double[]{0.2, 0.4, 0.6, 0.8, 1.0};
        double[] y = new double[]{-3.21888, -1.83258, -1.02165, -0.446287, 0.0};
        BolunmusFarklarTablosu tablo = new BolunmusFarklarTablosu(x, y);
        tablo.printTable();
    }
}