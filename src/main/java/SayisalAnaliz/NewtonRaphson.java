package SayisalAnaliz;

public class NewtonRaphson {
    double baslangicNoktasi;
    double hata;

    double denklem(double x) {
        return Math.exp(x) - 2.0;
    }

    double turev(double x) {
        return Math.exp(x);
    }

    public NewtonRaphson(double baslangicNoktasi, double hata) {
        this.baslangicNoktasi = baslangicNoktasi;
        this.hata = hata;
    }

    void newtonRaphson() {
        double kok = 0.0;
        double temp = 0.0;
        int iterasyonSayisi = 0;

        double hata;
        do {
            this.iterasyonGoster(this.baslangicNoktasi, kok, iterasyonSayisi);
            kok = this.baslangicNoktasi - this.denklem(this.baslangicNoktasi) / this.turev(this.baslangicNoktasi);
            temp = this.baslangicNoktasi;
            this.baslangicNoktasi = kok;
            kok = temp;
            ++iterasyonSayisi;
            hata = Math.abs(kok - this.baslangicNoktasi);
        } while(!(hata < this.hata));

        this.iterasyonGoster(this.baslangicNoktasi, kok, iterasyonSayisi);
        System.out.println("kok " + kok + ", hata " + this.hata);
    }

    void iterasyonGoster(double x0, double kok, int iterasyonSayisi) {
        if (iterasyonSayisi == 0) {
            System.out.println("baslancigta --- kok = x0 - f(" + x0 + ")/f'(" + x0 + ")-----------" + kok + " = " + x0 + "- " + this.denklem(x0) + " / " + this.turev(x0));
        } else {
            System.out.println("" + iterasyonSayisi + ".iterasyon---kok = x0 - f(" + x0 + ")/f'(" + x0 + ")-----------" + kok + " = " + x0 + "- " + this.denklem(x0) + " / " + this.turev(x0));
        }

    }
}