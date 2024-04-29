package SayisalAnaliz;


public class HeunYontemi {
    private double baslangicT;
    private double baslangicY;
    private double h;
    private int adimSayisi;

    public HeunYontemi(double baslangicT, double baslangicY, double h, int adimSayisi) {
        this.baslangicT = baslangicT;
        this.baslangicY = baslangicY;
        this.h = h;
        this.adimSayisi = adimSayisi;
    }

    private double differansiyelDenklem(double t, double y) {
        return (t - y) / 2.0;
    }

    public void heunMetoduHesapla() {
        double t = this.baslangicT;
        double y = this.baslangicY;
        System.out.println("Başlangıç değerleri: t = " + t + ", y = " + y);

        for(int i = 1; i <= this.adimSayisi; ++i) {
            double k1 = this.h * this.differansiyelDenklem(t, y);
            double k2 = this.h * this.differansiyelDenklem(t + this.h, y + k1);
            double eskiY = y;
            y += 0.5 * (k1 + k2);
            t += this.h;
            System.out.println("" + i + ". adım: t = " + t + ", y = " + y + ", k1 = " + k1 + ", k2 = " + k2 + ", formül: y = y + 0.5 * (k1 + k2) = " + eskiY + " + 0.5 * (" + k1 + " + " + k2 + ") = " + y);
        }

    }
}