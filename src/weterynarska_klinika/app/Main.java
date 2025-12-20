package weterynarska_klinika.app;

import weterynarska_klinika.enumy.GatunekZwierzecia;
import weterynarska_klinika.enumy.StatusZwierzecia;
import weterynarska_klinika.enumy.RodzajPlatnosci;
import weterynarska_klinika.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KlinikaWetenaryjna klinika = new KlinikaWetenaryjna();

        Weterynarz w1 = new Weterynarz("Jan", "Kowalski", "Chirurgia");
        Weterynarz w2 = new Weterynarz("Anna", "Nowak", "Szczepienia");

        klinika.dodajZwierze(new Zwierze("Fafik", GatunekZwierzecia.PIES));
        klinika.dodajZwierze(new Zwierze("Puszek", GatunekZwierzecia.KOT));
        klinika.dodajZwierze(new Zwierze("Artutek", GatunekZwierzecia.CHOMIK));
        klinika.dodajZwierze(new Zwierze("Ćwik Maksiu", GatunekZwierzecia.PAPUGA));

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU KLINIKI ===");
            System.out.println("1. Dodaj nowego zwierzaka");
            System.out.println("2. Pokaż wszystkich pacjentów");
            System.out.println("3. Usuń zwierzaka");
            System.out.println("4. Zmień status zwierzaka");
            System.out.println("5. Dodaj wizytę");
            System.out.println("6. Dodaj płatność dla zwierzaka");
            System.out.println("7. Wyjście z programu");
            System.out.print("Wybierz opcję: ");

            String opcja = scanner.nextLine();

            switch (opcja) {
                case "1":
                    System.out.print("Podaj imię zwierzaka: ");
                    String imie = scanner.nextLine();

                    GatunekZwierzecia gatunekZwierzecia = null;
                    while (gatunekZwierzecia == null) {
                        System.out.println("Wybierz gatunek:");
                        System.out.println("[1] Pies");
                        System.out.println("[2] Chomik");
                        System.out.println("[3] Kot");
                        System.out.println("[4] Papuga");
                        System.out.print("Twój wybór: ");

                        String input = scanner.nextLine();
                        switch (input) {
                            case "1" -> gatunekZwierzecia = GatunekZwierzecia.PIES;
                            case "2" -> gatunekZwierzecia = GatunekZwierzecia.CHOMIK;
                            case "3" -> gatunekZwierzecia = GatunekZwierzecia.KOT;
                            case "4" -> gatunekZwierzecia = GatunekZwierzecia.PAPUGA;
                            default -> System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
                        }
                    }

                    Zwierze nowe = new Zwierze(imie, gatunekZwierzecia);
                    klinika.dodajZwierze(nowe);
                    System.out.println("Dodano zwierzaka: " + nowe);
                    break;

                case "2":
                    System.out.println("\nLista pacjentów:");
                    klinika.pokazPacjentow();
                    break;

                case "3":
                    System.out.print("Podaj imię zwierzaka do usunięcia: ");
                    String imieDoUsuniecia = scanner.nextLine();
                    Zwierze doUsuniecia = klinika.znajdzPoImieniu(imieDoUsuniecia);
                    if (doUsuniecia != null) {
                        klinika.usunZwierze(doUsuniecia);
                        System.out.println("Usunięto zwierzaka: " + doUsuniecia.getImie());
                    } else {
                        System.out.println("Nie znaleziono zwierzaka o imieniu: " + imieDoUsuniecia);
                    }
                    break;

                case "4":
                    System.out.print("Podaj imię zwierzaka do zmiany statusu: ");
                    String imieStatus = scanner.nextLine();
                    Zwierze doZmianyStatusu = klinika.znajdzPoImieniu(imieStatus);
                    if (doZmianyStatusu != null) {
                        System.out.println("Wybierz nowy status:");
                        System.out.println("[1] PRZYJETY");
                        System.out.println("[2] W_TRAKCIE_LECZENIA");
                        System.out.println("[3] W_ZABIEGU");
                        System.out.println("[4] WYPISANY");
                        String statusInput = scanner.nextLine();
                        StatusZwierzecia status = switch (statusInput) {
                            case "1" -> StatusZwierzecia.PRZYJETY;
                            case "2" -> StatusZwierzecia.W_TRAKCIE_LECZENIA;
                            case "3" -> StatusZwierzecia.W_ZABIEGU;
                            case "4" -> StatusZwierzecia.WYPISANY;
                            default -> {
                                System.out.println("Nieprawidłowa opcja. Status nie zmieniony.");
                                yield null;
                            }
                        };
                        if (status != null) {
                            StatusManager.zmienStatus(doZmianyStatusu, status);
                            System.out.println("Status zmieniony: " + doZmianyStatusu);
                        }
                    } else {
                        System.out.println("Nie znaleziono zwierzaka o imieniu: " + imieStatus);
                    }
                    break;

                case "5":
                    System.out.print("Podaj imię zwierzaka do dodania wizyty: ");
                    String imieWizyta = scanner.nextLine();
                    Zwierze pacjentWizyta = klinika.znajdzPoImieniu(imieWizyta);
                    if (pacjentWizyta != null) {
                        System.out.print("Podaj opis wizyty: ");
                        String opis = scanner.nextLine();
                        System.out.print("Podaj cenę wizyty: ");
                        double cena;
                        try {
                            cena = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna cena. Operacja przerwana.");
                            break;
                        }

                        Wizyta nowaWizyta = new Wizyta(LocalDate.now(), opis, pacjentWizyta, cena);
                        klinika.dodajWizyte(nowaWizyta);
                        System.out.println("Dodano wizytę: " + nowaWizyta);
                    } else {
                        System.out.println("Nie znaleziono zwierzaka o imieniu: " + imieWizyta);
                    }
                    break;

                case "6":
                    System.out.print("Podaj imię zwierzaka do dodania płatności: ");
                    String imiePlatnosc = scanner.nextLine();
                    Zwierze pacjentPlatnosc = klinika.znajdzPoImieniu(imiePlatnosc);
                    if (pacjentPlatnosc != null) {
                        System.out.print("Podaj kwotę płatności: ");
                        double kwota;
                        try {
                            kwota = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna kwota. Operacja przerwana.");
                            break;
                        }
                        System.out.println("Wybierz rodzaj płatności:");
                        System.out.println("[1] GOTÓWKA");
                        System.out.println("[2] BLIK");
                        System.out.println("[3] KARTA");
                        String rodzajInput = scanner.nextLine();
                        RodzajPlatnosci rodzaj = switch (rodzajInput) {
                            case "1" -> RodzajPlatnosci.GOTOWKA;
                            case "2" -> RodzajPlatnosci.BLIK;
                            case "3" -> RodzajPlatnosci.KARTA;
                            default -> {
                                System.out.println("Niepoprawna opcja. Płatność nie dodana.");
                                yield null;
                            }
                        };
                        if (rodzaj != null) {
                            Platnosc platnosc = new Platnosc(kwota, rodzaj);
                            klinika.dodajPlatnosc(pacjentPlatnosc, platnosc);
                            System.out.println("Dodano płatność: " + platnosc);
                        }
                    } else {
                        System.out.println("Nie znaleziono zwierzaka o imieniu: " + imiePlatnosc);
                    }
                    break;

                case "7":
                    running = false;
                    System.out.println("Koniec programu. Do widzenia!");
                    break;

                default:
                    System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
            }
        }

        scanner.close();
    }
}
