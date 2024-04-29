package org.example;

public class LagrangePolinomu {
    private double[] xDegerleri;
    private double[] yDegerleri;

    public LagrangePolinomu(double[] xDegerleri, double[] yDegerleri) {
        this.xDegerleri = xDegerleri;
        this.yDegerleri = yDegerleri;
    }

    public String polinomuAl() {
        StringBuilder sonuc = new StringBuilder();

        for(int i = 0; i < this.xDegerleri.length; ++i) {
            sonuc.append(String.format("%.5f", this.yDegerleri[i]));

            for(int j = 0; j < this.xDegerleri.length; ++j) {
                if (i != j) {
                    sonuc.append(String.format(" * ((x - %.5f)/%.5f)", this.xDegerleri[j], this.xDegerleri[i] - this.xDegerleri[j]));
                }
            }

            if (i != this.xDegerleri.length - 1) {
                sonuc.append(" + \n");
            }
        }

        return sonuc.toString();
    }
}