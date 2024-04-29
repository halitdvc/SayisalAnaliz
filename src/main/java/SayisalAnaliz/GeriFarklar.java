package SayisalAnaliz;


public class GeriFarklar {
    public GeriFarklar() {
    }

    public double turevHesapla(double[] x, double[] y, double h, int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Türev hesaplamak için geçerli bir indeks belirtmelisiniz.");
        } else {
            return (y[index] - y[index - 1]) / h;
        }
    }

    public void sonucuYazdir(double[] x, double[] y, double h, int index) {
        double turev = this.turevHesapla(x, y, h, index);
        String formul = "(y[i] - y[i-1]) / h";
        formul = formul.replace("y[i]", String.valueOf(y[index])).replace("y[i-1]", String.valueOf(y[index - 1])).replace("h", String.valueOf(h));
        System.out.println("Formül: " + formul);
        System.out.println("Türev: " + turev);
    }
}