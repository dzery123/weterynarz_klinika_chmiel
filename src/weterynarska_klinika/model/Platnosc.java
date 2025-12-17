package weterynarska_klinika.model;

import weterynarska_klinika.enumy.RodzajPlatnosci;

public class Platnosc {

    private double kwota;
    private RodzajPlatnosci rodzaj;

    public Platnosc(double kwota) {
        this.kwota = kwota;
        this.rodzaj = RodzajPlatnosci.GOTOWKA;
    }

    public Platnosc(double kwota, RodzajPlatnosci rodzaj) {
        this.kwota = kwota;
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return kwota + " zł - " + rodzaj;
    }
}
