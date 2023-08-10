package org.example;

import java.util.Scanner;

import static org.example.Berechnung.bezahlung;

public class Bestellaenderung {

static Berechnung berechnung = new Berechnung();
      static void storZurYoN(Scanner scanner, Books storZur){
        System.out.println("Möchten Sie die Bücher stornieren oder zurücksetzen (y/n)?: ");
        char yOdern = scanner.nextLine().charAt(0);
        if(yOdern =='y') {

            storZur(scanner, storZur);
        } else if(yOdern =='n') {


            berechnung.kaufAusleiYoN(scanner, storZur);
        } else {
            System.out.println("Ungültige Auswahl.");
        }
    }





//**********************STORNIEREN******************************************************


     static void storZur(Scanner scanner, Books storZur) {
        Books books = new Books();
        System.out.println("die Bestellungen stornieren (s) oder zurücksetzen (z)?: ");

        char zurueckStor = scanner.nextLine().charAt(0);

        if (zurueckStor == 's') {
            storZur.gekaufteBuecher.clear();
            storZur.gesamtPreis = 0;
            System.out.println("Die Auswahl der Bücher wurde storniert." + storZur.gesamtPreis);
            books.menu();
        } else if (zurueckStor == 'z') {
            zurueksetzen(scanner, storZur);

        }
    }



     static void zurueksetzen(Scanner scanner, Books storZur) {
        System.out.print("Welches Buch möchten Sie zurücksetzen? Geben Sie die index des Buchs ein: ");
        int buchNummer = scanner.nextInt();
        scanner.nextLine();

        if (buchNummer >= 1 && buchNummer <= storZur.gekaufteBuecher.size()) {
            Books zurueckzusetzendesBuch = storZur.gekaufteBuecher.remove(buchNummer - 1);
            storZur.gesamtPreis -= zurueckzusetzendesBuch.preis;
            System.out.println("Das Buch '" + zurueckzusetzendesBuch.genres + "' wurde zurückgesetzt.");
            System.out.println("\nRestliche Bücher: ");
            for (Books buch : storZur.gekaufteBuecher) {
                System.out.println(buch);
            }
        }
        bezahlung(scanner);
    }

}
