package weterynarska_klinika.model;

import weterynarska_klinika.enumy.GatunekZwierzecia;
import weterynarska_klinika.enumy.StatusZwierzecia;

public class Zwierze {

    private String imie;
    private GatunekZwierzecia gatunek;
    private StatusZwierzecia status;

    public Zwierze(String imie, GatunekZwierzecia gatunek) {
        this.imie = imie;
        this.gatunek = gatunek;
        this.status = StatusZwierzecia.PRZYJETY;
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

    @Override
    public String toString() {
        return imie + " (" + gatunek + ") - " + status;
    }
}
