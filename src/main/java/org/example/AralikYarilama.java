package org.example;


public class AralikYarilama {
    double ustSinir;
    double altSinir;
    double hata;

    double denklem(double x) {
        return 3.0 * x + Math.sin(x) - Math.exp(x);
    }

    public AralikYarilama(double ustSinir, double altSinir, double hata) {
        this.ustSinir = ustSinir;
        this.altSinir = altSinir;
        this.hata = hata;
    }

    void AralikYarilama() {
        System.out.println("----alt sinir---orta nokta----ust sinir---");
        if (this.denklem(this.altSinir) * this.denklem(this.ustSinir) >= 0.0) {
            System.out.println("hatali aralik");
        }

        int iterasyonSayisi = 0;
        double ortaNokta = (this.altSinir + this.ustSinir) / 2.0;
        this.iterasyonGoster(this.altSinir, this.ustSinir, ortaNokta, iterasyonSayisi);

        while(Math.abs(this.ustSinir - this.altSinir) >= this.hata) {
            ++iterasyonSayisi;
            ortaNokta = (this.altSinir + this.ustSinir) / 2.0;
            this.iterasyonGoster(this.altSinir, this.ustSinir, ortaNokta, iterasyonSayisi);
            if (this.denklem(ortaNokta) == 0.0) {
                break;
            }

            if (this.denklem(ortaNokta) * this.denklem(this.altSinir) < 0.0) {
                this.ustSinir = ortaNokta;
            } else {
                this.altSinir = ortaNokta;
            }
        }

        System.out.println("kok = " + ortaNokta);
    }

    void iterasyonGoster(double altSinir, double ustSinir, double ortaNokta, int iterasyonSayisi) {
        if (iterasyonSayisi == 0) {
            System.out.println("baslancigta ---" + altSinir + "-----" + ortaNokta + "------" + ustSinir + "---");
        } else {
            System.out.println("" + iterasyonSayisi + ".iterasyon ---" + altSinir + "-----" + ortaNokta + "------" + ustSinir + "---");
        }

    }
}