package org.example;



public class RungeKuttaYontemi {
    private double baslangicT;
    private double baslangicY;
    private double h;
    private int adimSayisi;

    public RungeKuttaYontemi(double baslangicT, double baslangicY, double h, int adimSayisi) {
        this.baslangicT = baslangicT;
        this.baslangicY = baslangicY;
        this.h = h;
        this.adimSayisi = adimSayisi;
    }

    private double differansiyelDenklem(double t, double y) {
        return (5.0 * t * t - y) / Math.exp(t + y);
    }

    public void rungeKuttaMetoduHesapla() {
        double t = this.baslangicT;
        double y = this.baslangicY;
        System.out.println("Başlangıç değerleri: t = " + t + ", y = " + y);

        for(int i = 1; i <= this.adimSayisi; ++i) {
            double k1 = this.h * this.differansiyelDenklem(t, y);
            double k2 = this.h * this.differansiyelDenklem(t + this.h, y + k1);
            double eskiY = y;
            y += (k1 + k2) / 2.0;
            t += this.h;
            System.out.println("" + i + ". adım: t = " + t + ", y = " + y + ", k1 = " + k1 + ", k2 = " + k2 + ", formül: y = y + (k1 + k2) / 2 = " + eskiY + " + (" + k1 + " + " + k2 + ") / 2 = " + y);
        }

    }
}