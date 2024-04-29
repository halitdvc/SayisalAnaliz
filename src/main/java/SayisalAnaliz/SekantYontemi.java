package SayisalAnaliz;


public class SekantYontemi {
    double x0;
    double x1;
    double hata;

    double denklem(double x) {
        return Math.exp(-2.0 * x) - x;
    }

    public SekantYontemi(double x0, double x1, double hata) {
        this.x0 = x0;
        this.x1 = x1;
        this.hata = hata;
    }

    void sekantYontemi() {
        int iterasyonSayisi = 0;

        double hata;
        do {
            this.iterasyonGoster(this.x0, this.x1, iterasyonSayisi);
            double temp = this.x1;
            this.x1 -= this.denklem(this.x1) * (this.x1 - this.x0) / (this.denklem(this.x1) - this.denklem(this.x0));
            this.x0 = temp;
            ++iterasyonSayisi;
            hata = Math.abs(this.x1 - this.x0);
        } while(!(hata < this.hata));

        this.iterasyonGoster(this.x0, this.x1, iterasyonSayisi);
        System.out.println("Kök " + this.x1 + ", Hata " + this.hata);
    }

    void iterasyonGoster(double x0, double x1, int iterasyonSayisi) {
        if (iterasyonSayisi == 0) {
            System.out.println();
            System.out.println("--------UNUTMA X2 = X1 - F(X1)...... SEKLINDE GIDIYOR YA HESABIN SONUCU BI ALT ITERASYONDA YERINDE------- ");
            System.out.println("Başlangıçta --- x2 = x1 - f(x1)(x1 - x0)/(f(x1) - f(x0)) ------------ x" + (iterasyonSayisi + 2) + " = " + x1 + " - " + this.denklem(x1) + "(" + x1 + " - " + x0 + ")/(" + this.denklem(x1) + " - " + this.denklem(x0) + ")");
        } else {
            System.out.println(iterasyonSayisi + 1 + ". Iterasyon --- x" + (iterasyonSayisi + 2) + " = x" + (iterasyonSayisi + 1) + " - f(x" + (iterasyonSayisi + 1) + ")(x" + (iterasyonSayisi + 1) + " - x" + iterasyonSayisi + ")/(f(x" + (iterasyonSayisi + 1) + ") - f(x" + iterasyonSayisi + ")) ------------x" + (iterasyonSayisi + 2) + " = " + x1 + " - " + this.denklem(x1) + "(" + x1 + " - " + x0 + ")/(" + this.denklem(x1) + " - " + this.denklem(x0) + ")==>" + x1);
        }

    }
}