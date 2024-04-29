package org.example;


public class KuadratikInterpolasyon {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public KuadratikInterpolasyon(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double tahminEt(double x) {
        double y = this.y1 * (x - this.x2) * (x - this.x3) / ((this.x1 - this.x2) * (this.x1 - this.x3)) + this.y2 * (x - this.x1) * (x - this.x3) / ((this.x2 - this.x1) * (this.x2 - this.x3)) + this.y3 * (x - this.x1) * (x - this.x2) / ((this.x3 - this.x1) * (this.x3 - this.x2));
        return y;
    }
}