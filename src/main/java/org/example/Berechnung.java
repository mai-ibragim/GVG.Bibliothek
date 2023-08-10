package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Berechnung {

      void kaufAusleiYoN(Scanner scanner, Books storZur) {
        System.out.print("\nMöchten Sie jetzt kaufen (k) oder ausleihen (a)? ");
        char kaufOderAusleihe = scanner.nextLine().charAt(0);

        if (kaufOderAusleihe == 'k') {
            for (Books buch : storZur.gekaufteBuecher) {
                storZur.gesamtPreis += buch.preis;
            }

        } else if (kaufOderAusleihe == 'a') {
            int ausleihGebuehr = 5;
            System.out.println("Wie viel Buch möchten Sie ausleihen?: ");
            int wieViel = scanner.nextInt();
            wieViel*=ausleihGebuehr;
            System.out.println("Ausleihgebühr für ein Buch: " + ausleihGebuehr + "€. Insgesamt sind: " + wieViel + "€");
            kartKred(scanner, storZur);
        } else {
            System.out.println("Ungültige Auswahl.");
        }
        kartKred(scanner, storZur);
    }





     static void kartKred(Scanner scanner, Books storZur) {
        Books books = new Books();
        System.out.print("Möchten Sie mit Karte (d) oder Kreditkarte (m) bezahlen? ");
        char zahlungsmethode = scanner.nextLine().charAt(0);

        if (zahlungsmethode == 'd') {
            System.out.println("Gesamtpreis: " + storZur.gesamtPreis + " EUR - Bezahlt mit Karte");
        } else if (zahlungsmethode == 'm') {
            System.out.println("Gesamtpreis: " + storZur.gesamtPreis + " EUR - Bezahlt mit Kreditkarte");
        } else {
            System.out.println("Ungültige Auswahl.");
        }
        books.menu();
    }




     static void bezahlung(Scanner scanner) {
        Books books = new Books();
        int gesamtPreis = 0;
        List<Books> gekaufteBuecher = new ArrayList<>();
        System.out.print("Möchten Sie mit Karte (d) oder Kreditkarte (m) bezahlen? ");
        char zahlungsmethode = scanner.nextLine().charAt(0);
        if (zahlungsmethode == 'd') {
            for (Books buch : gekaufteBuecher) {
                gesamtPreis += buch.preis;
            }
            System.out.println("Gesamtpreis: " + gesamtPreis + " EUR - Bezahlt mit Karte");

        } else if (zahlungsmethode == 'm') {
            for (Books buch : gekaufteBuecher) {
                gesamtPreis += buch.preis;
            }
            System.out.println("Gesamtpreis: " + gesamtPreis + " EUR - Bezahlt mit Kreditkarte");
        } else {
            System.out.println("Ungültige Auswahl.");
        }
        books.menu();
    }
}
