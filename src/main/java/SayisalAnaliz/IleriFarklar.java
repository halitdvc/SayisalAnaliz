package SayisalAnaliz;


public class IleriFarklar {
    public IleriFarklar() {
    }

    public double turevHesapla(double[] x, double[] y, double h, int index) {
        if (index == x.length - 1) {
            throw new IllegalArgumentException("Türev hesaplamak için geçerli bir indeks belirtmelisiniz.");
        } else {
            return (y[index + 1] - y[index]) / h;
        }
    }

    public void sonucuYazdir(double[] x, double[] y, double h, int index) {
        double turev = this.turevHesapla(x, y, h, index);
        String formul = "(y[i+1] - y[i]) / h";
        formul = formul.replace("y[i+1]", String.valueOf(y[index + 1])).replace("y[i]", String.valueOf(y[index])).replace("h", String.valueOf(h));
        System.out.println("Formül: " + formul);
        System.out.println("Türev: " + turev);
    }
}