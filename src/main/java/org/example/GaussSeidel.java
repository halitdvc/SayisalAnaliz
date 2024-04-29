package org.example;


public class GaussSeidel {
    private double[][] A;
    private double[] B;
    private double[] X;

    public GaussSeidel(double[][] a, double[] b, double[] x) {
        this.A = a;
        this.B = b;
        this.X = x;
    }

    public void cozVeYazdir() {
        int n = this.A.length;
        double[] yeniX = new double[n];
        System.arraycopy(this.X, 0, yeniX, 0, n);
        int maxIterasyon = 10;
        int i;
        for(i = 0; i < maxIterasyon; ++i) {
            for(int j = 0; j < n; ++j) {    // 'j' değişkeni iç döngüyü kontrol etmek için kullanılır
                double sum = this.B[j];
                for(int k = 0; k < n; ++k) {     // 'k' değişkeni üçüncü döngüyü kontrol etmek için kullanılır
                    if (k != j) {
                        sum -= this.A[j][k] * yeniX[k];
                    }
                }
                yeniX[j] = 1.0 / this.A[j][j] * sum;
            }
            System.out.printf("\n%d. adımdaki çözüm:\n", i);
            for(int j = 0; j < n; ++j) {
                System.out.printf("X%d = %.5f\n", j + 1, yeniX[j]);
            }
        }
        System.out.println("\nSon Çözüm:");
        for(int j = 0; j < n; ++j) {
            System.out.printf("X%d = %.5f\n", j + 1, yeniX[j]);
        }
    }
}