package weterynarska_klinika.model;

import java.util.ArrayList;
import java.util.List;

public class KlinikaWetenaryjna {
    private List<Zwierze> pacjenci = new ArrayList<>();
    private List<Wizyta> wizyty = new ArrayList<>();

    public void dodajZwierze(Zwierze z) {
        pacjenci.add(z);

    }

    public void usunZwierze(Zwierze z) {
        pacjenci.remove(z);

    }

    public Zwierze znajdzPoImieniu(String imie) {
        for (Zwierze z : pacjenci) {
            if (z.getImie().equalsIgnoreCase(imie)) {
                return z;
            }
        }
        return null;
    }

    public void dodajWizyte(Wizyta w) {
        wizyty.add(w);
    }

    public void pokazPacjentow() {
        pacjenci.forEach(z ->
                System.out.println(z.getImie() + " (" + z.getGatunek() + ", status zwierzecia : " + z.getStatus() + ")")
        );
    }

    public void pokazWizyty() {
        wizyty.forEach(System.out::println);
    }

}
