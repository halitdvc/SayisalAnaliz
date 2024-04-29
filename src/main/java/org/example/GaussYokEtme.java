package org.example;


public class GaussYokEtme {
    private double[][] A;
    private double[] B;

    public GaussYokEtme(double[][] a, double[] b) {
        this.A = a;
        this.B = b;
    }

    private void matrisiYazdir() {
        for(int i = 0; i < this.A.length; ++i) {
            for(int j = 0; j < this.A[0].length; ++j) {
                System.out.printf("%.2f ", this.A[i][j]);
            }

            System.out.printf("| %.2f\n", this.B[i]);
        }

    }

    public void cozVeYazdir() {
        int n = this.B.length;

        int i;
        for(int p = 0; p < n; ++p) {
            i = p;

            for (int j = p + 1; j < n; j++) {
                if (Math.abs(this.A[j][p]) > Math.abs(this.A[i][p])) {
                    i = j;
                }
            }

            double[] gecici = this.A[p];
            this.A[p] = this.A[i];
            this.A[i] = gecici;
            double t = this.B[p];
            this.B[p] = this.B[i];
            this.B[i] = t;
            System.out.printf("\n%d. adım sonrası matris (pivot değişti):\n", p + 1);
            this.matrisiYazdir();

            for (int row = p + 1; row < n; row++) {
                double alpha = this.A[i][p] / this.A[p][p];

                double[] var10000;
                for(int j = p; j < n; ++j) {
                    var10000 = this.A[i];
                    var10000[j] -= alpha * this.A[p][j];
                }

                var10000 = this.B;
                var10000[i] -= alpha * this.B[p];
            }

            System.out.printf("\n%d. adımdan sonra matris (alt sıfırlandı):\n", p + 1);
            this.matrisiYazdir();
        }

        double[] cozum = new double[n];

        for(i = n - 1; i >= 0; --i) {
            double sum = 0.0;

            for(int j = i + 1; j < n; ++j) {
                sum += this.A[i][j] * cozum[j];
            }

            cozum[i] = (this.B[i] - sum) / this.A[i][i];
        }

        System.out.println("\nÇözüm:");

        for(i = 0; i < cozum.length; ++i) {
            System.out.printf("X%d = %.2f\n", i + 1, cozum[i]);
        }

    }
}