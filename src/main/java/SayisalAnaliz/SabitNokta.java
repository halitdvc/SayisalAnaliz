package SayisalAnaliz;


public class SabitNokta {
    double x0;
    double hata;

    double g(double x) {
        return 1.4 * Math.sin(x);
    }

    public SabitNokta(double x0, double hata) {
        this.x0 = x0;
        this.hata = hata;
    }

    void sabitNoktaYontemi() {
        int iterasyonSayisi = 0;

        while(true) {
            this.iterasyonGoster(this.x0, iterasyonSayisi);
            double x1 = this.g(this.x0);
            double hata = Math.abs(x1 - this.x0);
            if (hata < this.hata) {
                System.out.println("Kök " + this.x0 + ", Hata " + this.hata);
                return;
            }

            this.x0 = x1;
            ++iterasyonSayisi;
        }
    }

    void iterasyonGoster(double x0, int iterasyonSayisi) {
        System.out.println(iterasyonSayisi + 1 + ". Iterasyon --- x" + (iterasyonSayisi + 1) + " = g(x" + iterasyonSayisi + ") ------------ x" + (iterasyonSayisi + 1) + " = " + this.g(x0));
    }
}