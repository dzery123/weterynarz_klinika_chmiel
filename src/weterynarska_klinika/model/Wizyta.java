package weterynarska_klinika.model;

import java.time.LocalDate;

public class Wizyta {
    private Zwierze zwierze;
    private LocalDate data;
    private String opis;

    public Wizyta(LocalDate data, String opis, Zwierze zwierze) {
        this.data = data;
        this.opis = opis;
        this.zwierze = zwierze;
    }

    @Override
    public String toString() {
        return data + " - " + zwierze.getImie() + ": " + opis;
    }
}
