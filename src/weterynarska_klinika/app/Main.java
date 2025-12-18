package weterynarska_klinika.app;

import weterynarska_klinika.enumy.GatunekZwierzecia;
import weterynarska_klinika.model.KlinikaWetenaryjna;
import weterynarska_klinika.model.Zwierze;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KlinikaWetenaryjna klinika = new KlinikaWetenaryjna();
        System.out.println("Witamy w programie Narodoweej Kliniki Weterynarskiej obsługującej: Papugi, Psy, Chomiki i Koty!");
        System.out.println("Czy chcesz dodać nowego zwierzaka? [T/N]");
        String wybor = scanner.nextLine();
        String imie = null;
        GatunekZwierzecia gatunekZwierzecia = null;
        if (wybor.equals("T")) {
            System.out.println("Podaj imie swojego zwierzaka");
            imie = scanner.nextLine();
            System.out.println("Wybierz gatunek przez dopisanie odpowiedniej opcji:");
            System.out.println("[1] Pies");
            System.out.println("[2] Chomik");
            System.out.println("[3] Kot");
            System.out.println("[4] Papuga");
            int gatunek = scanner.nextInt();
            gatunekZwierzecia = null;

            if (gatunek == 1) {
                gatunekZwierzecia = GatunekZwierzecia.PIES;
            } else if (gatunek == 2) {
                gatunekZwierzecia = GatunekZwierzecia.CHOMIK;
            } else if (gatunek == 3) {
                gatunekZwierzecia = GatunekZwierzecia.KOT;
            } else if (gatunek == 4) {
                gatunekZwierzecia = GatunekZwierzecia.PAPUGA;
            } else {
                System.out.println("Błąd, nie ma takiego gatunku, chcesz go wprowadzić ponownie? [T/N]");
                String blad = scanner.nextLine();
                if (blad.equals("T")) {
                    System.out.println("Wybierz gatunek przez dopisanie odpowiedniej opcji:");
                    System.out.println("[1] Pies");
                    System.out.println("[2] Chomik");
                    System.out.println("[3] Kot");
                    System.out.println("[4] Papuga");
                    gatunek = scanner.nextInt();

                } else System.out.println("Błędne dodanie zwierzęcia");


            }


        } else System.out.println("======================================================");


        Zwierze z1 = new Zwierze("Fafik", GatunekZwierzecia.PIES);
        Zwierze z2 = new Zwierze("Puszek", GatunekZwierzecia.KOT);
        Zwierze z3 = new Zwierze("Artutek", GatunekZwierzecia.CHOMIK);
        Zwierze z4 = new Zwierze("Ćwik Maksiu", GatunekZwierzecia.PAPUGA);
        Zwierze twoje = new Zwierze(imie, gatunekZwierzecia);


        klinika.dodajZwierze(z1);
        klinika.dodajZwierze(z2);
        klinika.dodajZwierze(z3);
        klinika.dodajZwierze(z4);
        klinika.dodajZwierze(twoje);


    }
}
