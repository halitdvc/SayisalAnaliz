package org.example;

public class Jakobi {
    private double[][] A;
    private double[] B;
    private double[] X;

    public Jakobi(double[][] a, double[] b, double[] x) {
        this.A = a;
        this.B = b;
        this.X = x;
    }

    private void kosegenBaskinYap() {
        int n = this.A.length;

        for(int i = 0; i < n; ++i) {
            int maxIndeks = i;

            for(int j = i + 1; j < n; ++j) {
                if (Math.abs(this.A[j][i]) > Math.abs(this.A[maxIndeks][i])) {
                    maxIndeks = j;
                }
            }

            double[] temp = this.A[i];
            this.A[i] = this.A[maxIndeks];
            this.A[maxIndeks] = temp;
            double t = this.B[i];
            this.B[i] = this.B[maxIndeks];
            this.B[maxIndeks] = t;
        }

    }

    public void cozVeYazdir() {
        this.kosegenBaskinYap();
        int n = this.A.length;
        double[] yeniX = new double[n];
        System.arraycopy(this.X, 0, yeniX, 0, n);
        int maxIterasyon = 10;
        int i;
        for(i = 0; i < maxIterasyon; ++i) {
            double[] eskiX = new double[n];
            System.arraycopy(yeniX, 0, eskiX, 0, n);

            // Removed the second declaration of 'i'
            for(i = 0; i < n; ++i) {
                double sum = this.B[i];
                for(int j = 0; j < n; ++j) {
                    if (j != i) {
                        sum -= this.A[i][j] * eskiX[j];
                    }
                }
                yeniX[i] = 1.0 / this.A[i][i] * sum;
            }
            System.out.printf("\n%d. adımdaki çözüm:\n", i);
            for(i = 0; i < n; ++i) {
                System.out.printf("X%d = %.2f\n", i + 1, yeniX[i]);
            }
        }
        System.out.println("\nSon Çözüm:");
        for(i = 0; i < n; ++i) {
            System.out.printf("X%d = %.2f\n", i + 1, yeniX[i]);
        }
    }
}