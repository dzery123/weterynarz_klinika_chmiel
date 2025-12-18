package weterynarska_klinika.model;

import java.time.LocalDate;

public class Wizyta {
    private Zwierze zwierze;
    private LocalDate data;
    private String opis;
    private double cena;

    public Wizyta(LocalDate data, String opis, Zwierze zwierze, double cena) {
        this.data = data;
        this.opis = opis;
        this.zwierze = zwierze;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return data + " - " + zwierze.getImie() + ": " + opis + " usluga kosztowała: " + cena;
    }
}
