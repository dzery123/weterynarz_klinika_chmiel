package weterynarska_klinika.model;

public class Weterynarz {

    private String imie;
    private String nazwisko;
    private String specjalizacja;

    public Weterynarz(String imie, String nazwisko, String specjalizacja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.specjalizacja = specjalizacja;
    }

    public String getPelneDane() {
        return imie + " " + nazwisko + " (" + specjalizacja + ")";
    }
}
