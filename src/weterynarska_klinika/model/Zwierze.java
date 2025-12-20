package weterynarska_klinika.model;

import weterynarska_klinika.enumy.GatunekZwierzecia;
import weterynarska_klinika.enumy.StatusZwierzecia;
import java.util.ArrayList;
import java.util.List;

public class Zwierze {

    private String imie;
    private GatunekZwierzecia gatunek;
    private StatusZwierzecia status;
    private List<Platnosc> platnosci;

    public Zwierze(String imie, GatunekZwierzecia gatunek) {
        this.imie = imie;
        this.gatunek = gatunek;
        this.status = StatusZwierzecia.PRZYJETY;
        this.platnosci = new ArrayList<>();
    }

    public String getImie() {
        return imie;
    }

    public GatunekZwierzecia getGatunek() {
        return gatunek;
    }

    public StatusZwierzecia getStatus() {
        return status;
    }

    public void setStatus(StatusZwierzecia status) {
        this.status = status;
    }

    public List<Platnosc> getPlatnosci() {
        return platnosci;
    }

    public void dodajPlatnosc(Platnosc platnosc) {
        platnosci.add(platnosc);
    }

    @Override
    public String toString() {
        return imie + " (" + gatunek + ") - " + status;
    }
}
