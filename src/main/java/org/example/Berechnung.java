package org.example;

import java.util.Scanner;


public class Berechnung {

    static void kaufAusleiYoN(Scanner scanner, Book storZur) {
        Book book = new Book();
        try {
           int anzahlGekaufteBuecher = 0;
            System.out.print("\nMöchten Sie jetzt kaufen (k) oder ausleihen (a)? ");
            char kaufOderAusleihe = scanner.nextLine().charAt(0);

            if (kaufOderAusleihe == 'k') {
                for (Book buch : storZur.gekaufteBuecher) {
                    anzahlGekaufteBuecher++;
                    storZur.gesamtPreis += buch.preis;
                }
                    System.out.println("\nGesamtanzahl gekaufter Bücher: " + anzahlGekaufteBuecher);
                System.out.println("\nGekaufte Bücher: ");
                for (Book buch : storZur.gekaufteBuecher) {
                    System.out.println(buch);
                }
                    System.out.println("Gesamtpreis: " + storZur.gesamtPreis + " EUR");
                System.out.println("Geben Sie Ihre Kontonummer ein: ");
                    String kontonummer = scanner.nextLine();
                    if (isValidKontonummer(kontonummer)) {
                        System.out.println("Bestätigen Sie bitte mit (y), um zu bezahlen");
                        char bestaetigung = scanner.nextLine().charAt(0);
                        if (bestaetigung == 'y') {
                            System.out.println("Zahlung erfolgreich abgeschlossen!");
                            book.menuDe();
                        } else {
                            System.out.println("Sie haben die Bezahlung abgelehnt.");
                            book.menuDe();
                        }
                    }
            } else if (kaufOderAusleihe == 'a') {
                int wieViel = 0;
                int ausleihGebuehr = 5;
                for (Book buch : storZur.gekaufteBuecher) {
                    wieViel++;
                    storZur.gesamtPreis += ausleihGebuehr;
                }
                wieViel *= ausleihGebuehr;
                System.out.println("\nGekaufte Bücher: ");
                for (Book buch : storZur.gekaufteBuecher) {
                    System.out.println(buch);
                }
                System.out.println("Ausleihgebühr für ein Buch: " + ausleihGebuehr + "€.\nInsgesamt sind: " + wieViel + "€");
                System.out.println("Geben Sie Ihre Kontonummer ein: ");
                String kontonummer = scanner.nextLine();
                if (isValidKontonummer(kontonummer)) {
                    System.out.println("Bestätigen Sie bitte mit (y), um zu bezahlen");
                    char bestaetigung = scanner.nextLine().charAt(0);
                    if (bestaetigung == 'y') {
                        System.out.println("Zahlung erfolgreich abgeschlossen!");
                        book.menuDe();
                    } else {
                        System.out.println("Sie haben die Bezahlung abgelehnt.");
                        book.menuDe();
                    }
                }else {
                    System.out.println("Ungültige Auswahl.");
                    book.menuDe();
            }
            }
        } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            kaufAusleiYoN(scanner, storZur);
        }
    }
    private static boolean isValidKontonummer(String kontonummer) {
        return kontonummer.length() == 12 && kontonummer.matches("\\d+");
    }
}
