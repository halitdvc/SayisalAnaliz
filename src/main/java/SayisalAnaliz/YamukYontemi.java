package SayisalAnaliz;


public class YamukYontemi {
    private double altSinir;
    private double ustSinir;
    private int n;

    public YamukYontemi(double altSinir, double ustSinir, int n) {
        this.altSinir = altSinir;
        this.ustSinir = ustSinir;
        this.n = n;
    }

    public double integralHesapla() {
        double h = (this.ustSinir - this.altSinir) / (double)this.n;
        double integral = 0.0;

        for(int i = 1; i < this.n; ++i) {
            double xi = this.altSinir + (double)i * h;
            integral += this.fonksiyon(xi);
        }

        integral += (this.fonksiyon(this.altSinir) + this.fonksiyon(this.ustSinir)) / 2.0;
        integral *= h;
        return integral;
    }

    public double fonksiyon(double x) {
        return (Math.exp(x * x) + 1.0) / x * Math.sin(x);
    }

    public void sonucuYazdir() {
        double integral = this.integralHesapla();
        System.out.println("Integral değeri: " + integral);
        System.out.println("Denklem: (x^5 * sin(x-7)) / exp(x+2)");
    }

    public void cozumuYazdir() {
        double cozum = this.fonksiyon(this.altSinir);
        System.out.println("f(" + this.altSinir + ") = " + cozum);
    }
}