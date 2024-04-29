package SayisalAnaliz;


public class SimpsonYontemi {
    private double altSinir;
    private double ustSinir;
    private int noktaSayisi;

    public SimpsonYontemi(double altSinir, double ustSinir, int noktaSayisi) {
        this.altSinir = altSinir;
        this.ustSinir = ustSinir;
        this.noktaSayisi = noktaSayisi;
    }

    private double fonksiyon(double x) {
        return (Math.exp(x * x) + 1.0) / x * Math.sin(x);
    }

    public String ucUcuncuKuralHesapla() {
        double h = (this.ustSinir - this.altSinir) / (double)(this.noktaSayisi - 1);
        if (this.noktaSayisi % 2 == 0) {
            throw new IllegalArgumentException("Nokta sayısı tek olmalıdır.");
        } else {
            StringBuilder formuluYazdir = new StringBuilder("1/3 * [f(" + this.altSinir + ")");
            double sonuc = this.fonksiyon(this.altSinir);

            for(int i = 1; i < this.noktaSayisi - 1; ++i) {
                double x = this.altSinir + h * (double)i;
                int katsayi = i % 2 == 0 ? 2 : 4;
                formuluYazdir.append(" + ").append(katsayi).append("f(").append(x).append(")");
                sonuc += (double)katsayi * this.fonksiyon(x);
            }

            sonuc += this.fonksiyon(this.ustSinir);
            formuluYazdir.append(" + f(").append(this.ustSinir).append(")] = ").append(sonuc * h / 3.0);
            return formuluYazdir.toString();
        }
    }

    public String ucSekizinciKuralHesapla() {
        double h = (this.ustSinir - this.altSinir) / (3.0 * (double)(this.noktaSayisi - 1));
        if (this.noktaSayisi % 3 != 1) {
            throw new IllegalArgumentException("Nokta sayısı 3n+1 formunda olmalıdır (n bir tam sayı).");
        } else {
            StringBuilder formuluYazdir = new StringBuilder("3/8 * [f(" + this.altSinir + ")");
            double sonuc = this.fonksiyon(this.altSinir);

            for(int i = 1; i < this.noktaSayisi - 1; ++i) {
                double x = this.altSinir + h * (double)i;
                int katsayi = i % 3 == 0 ? 2 : 3;
                formuluYazdir.append(" + ").append(katsayi).append("f(").append(x).append(")");
                sonuc += (double)katsayi * this.fonksiyon(x);
            }

            sonuc += this.fonksiyon(this.ustSinir);
            formuluYazdir.append(" + f(").append(this.ustSinir).append(")] = ").append(3.0 * h * sonuc / 8.0);
            return formuluYazdir.toString();
        }
    }
}