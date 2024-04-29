package SayisalAnaliz;


public class BolunmusFarklarTablosu {
    private double[] x;
    private double[] y;
    private double[][] table;

    public BolunmusFarklarTablosu(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        this.table = new double[y.length][y.length];
        this.buildTable();
    }

    private void buildTable() {
        int j;
        for(j = 0; j < this.y.length; ++j) {
            this.table[j][0] = this.y[j];
        }

        for(j = 1; j < this.y.length; ++j) {
            for(int i = j; i < this.y.length; ++i) {
                this.table[i][j] = (this.table[i][j - 1] - this.table[i - 1][j - 1]) / (this.x[i] - this.x[i - j]);
            }
        }

    }

    public void printTable() {
        System.out.println("Xk\tf(x)\tf(x)\tf(x)\tf(x)\tf(x)\tf(x)");

        for(int i = 0; i < this.y.length; ++i) {
            System.out.printf("%.1f\t", this.x[i]);

            for(int j = 0; j <= i; ++j) {
                System.out.printf("%.5f\t", this.table[i][j]);
            }

            System.out.println();
        }

    }

    public double interpolate(double val) {
        double result = this.table[0][0];

        for(int i = 1; i < this.x.length; ++i) {
            double temp = this.table[i][i];

            for(int j = 0; j < i; ++j) {
                temp *= val - this.x[j];
            }

            result += temp;
        }

        return result;
    }
}