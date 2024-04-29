package SayisalAnaliz;


import java.util.Arrays;

public class Cramer {
    private int N;
    private double[][] A;
    private double[] B;

    public Cramer(double[][] a, double[] b) {
        this.A = a;
        this.B = b;
        this.N = a.length;
    }

    private double determinant(double[][] a, int n) {
        double det = 0.0;
        int sign = 1;
        if (n == 1) {
            return a[0][0];
        } else {
            double[][] subMatrix = new double[n][n];

            for(int x = 0; x < n; ++x) {
                int subi = 0;

                for(int i = 1; i < n; ++i) {
                    int subj = 0;

                    for(int j = 0; j < n; ++j) {
                        if (j != x) {
                            subMatrix[subi][subj] = a[i][j];
                            ++subj;
                        }
                    }

                    ++subi;
                }

                det += (double)sign * a[0][x] * this.determinant(subMatrix, n - 1);
                sign = -sign;
            }

            return det;
        }
    }

    private void printMatrix(double[][] a) {
        for(int i = 0; i < a.length; ++i) {
            for(int j = 0; j < a[i].length; ++j) {
                System.out.printf("%.2f ", a[i][j]);
            }

            System.out.println();
        }

    }

    public void solveAndPrint() {
        double det = this.determinant(this.A, this.N);
        if (det == 0.0) {
            throw new IllegalArgumentException("Determinant 0 olduğu için bu sistem çözülemez.");
        } else {
            System.out.println("Ana matris:");
            this.printMatrix(this.A);
            System.out.printf("Ana matrisin determinantı: %.2f\n\n", det);
            double[][] temp = new double[this.N][this.N];
            double[] x = new double[this.N];

            for(int i = 0; i < this.N; ++i) {
                int j;
                for(j = 0; j < this.N; ++j) {
                    temp[j] = Arrays.copyOf(this.A[j], this.N);
                }

                for(j = 0; j < this.N; ++j) {
                    temp[j][i] = this.B[j];
                }

                System.out.printf("%d. sütunu B vektörü ile değiştirilmiş matris:\n", i + 1);
                this.printMatrix(temp);
                double tempDet = this.determinant(temp, this.N);
                System.out.printf("Yeni matrisin determinantı: %.2f\n", tempDet);
                x[i] = tempDet / det;
                System.out.printf("X%d = %.2f\n\n", i + 1, x[i]);
            }

        }
    }
}