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

                    Book.warenkorb.show();
                kontonummer(scanner, book);

            } else if (kaufOderAusleihe == 'a') {

                int ausleihGebuehr = 5;

                System.out.println("\nBücher zum Ausleihen: ");
                for (Book buch : Book.warenkorb.bookList) {
                    System.out.println(buch);
                }
                System.out.println("Ausleihgebühr für ein Buch: " + ausleihGebuehr + "€.\nInsgesamt sind: " + ausleihGebuehr*Book.warenkorb.getAmount() + "€");
                kontonummer(scanner, book);
            }
        } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            kaufAusleiYoN(scanner, storZur);
        }
    }

    private static void kontonummer(Scanner scanner, Book book) {
        try {
            System.out.println("Geben Sie 12-stellige Kontonummer ein: ");
            String kontonummer = scanner.nextLine();

            if (isValidKontonummer(kontonummer)) {
                System.out.println("Bestätigen Sie bitte die Bezahlung mit (y): ");
                char bestaetigung = scanner.nextLine().charAt(0);
                if (bestaetigung == 'y') {
                    System.out.println("Zahlung wurde erfolgreich abgeschlossen!");
                    book.menu();
                } else {
                    System.out.println("Sie haben die Bezahlung abgelehnt.");
                    book.menu();
                }
            } else {
                System.out.println("Ungültige Kontonummer. Die Kontonummer muss 12-stellig sein.");
                kontonummer(scanner, book);
            }
        } catch (Exception e) {
            System.out.println("Die Kontonummer soll aus Zahlen sein.");
            kontonummer(scanner, book);
        }
    }

    private static boolean isValidKontonummer(String kontonummer) {
        return kontonummer.length() == 12 && kontonummer.matches("\\d+");
    }
}
