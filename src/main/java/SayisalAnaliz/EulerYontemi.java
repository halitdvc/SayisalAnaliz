package SayisalAnaliz;


public class EulerYontemi {
    private double baslangicT;
    private double baslangicY;
    private double h;
    private int adimSayisi;

    public EulerYontemi(double baslangicT, double baslangicY, double h, int adimSayisi) {
        this.baslangicT = baslangicT;
        this.baslangicY = baslangicY;
        this.h = h;
        this.adimSayisi = adimSayisi;
    }

    private double differansiyelDenklem(double t, double y) {
        return (5.0 * t * t - y) / Math.exp(t + y);
    }

    public void eulerMetoduHesapla() {
        double t = this.baslangicT;
        double y = this.baslangicY;
        System.out.println("Başlangıç değerleri: t = " + t + ", y = " + y);

        for(int i = 1; i <= this.adimSayisi; ++i) {
            double dy = this.h * this.differansiyelDenklem(t, y);
            y += dy;
            t += this.h;
            System.out.println("" + i + ". adım: t = " + t + ", y = " + y + ", dy = " + dy + ", formül: y = y + h * f(t, y) = " + y + " + " + this.h + " * f(" + t + ", " + y + ") = " + y);
        }

    }
}