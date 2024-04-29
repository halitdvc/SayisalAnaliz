package org.example;



public class MerkeziFarklar {
    public MerkeziFarklar() {
    }

    public double turevHesapla(double[] x, double[] y, double h, int index) {
        if (index != 0 && index != x.length - 1) {
            return (y[index + 1] - y[index - 1]) / (x[index + 1] - x[index - 1]);
        } else {
            throw new IllegalArgumentException("Türev hesaplamak için geçerli bir indeks belirtmelisiniz.");
        }
    }

    public void sonucuYazdir(double[] x, double[] y, double h, int index) {
        double turev = this.turevHesapla(x, y, h, index);
        String formul = "(y[i+1] - y[i-1]) / (x[i+1] - x[i-1])";
        formul = formul.replace("y[i+1]", String.valueOf(y[index + 1])).replace("y[i-1]", String.valueOf(y[index - 1])).replace("x[i+1]", String.valueOf(x[index + 1])).replace("x[i-1]", String.valueOf(x[index - 1]));
        System.out.println("Formül: " + formul);
        System.out.println("Türev: " + turev);
    }
}
