package org.example;

import java.util.Scanner;

public class Bestellaenderung {

static Berechnung berechnung = new Berechnung();
      static void storZurYoN(Scanner scanner, Book storZur){
          try {
              System.out.println("Möchten Sie die Bücher stornieren oder zurücksetzen (y/n)?: ");
              char yOdern = scanner.nextLine().charAt(0);
              if(yOdern =='y') {
                  storZur(scanner, storZur);
              } else if(yOdern =='n') {
                  berechnung.kaufAusleiYoN(scanner, storZur);
              } else {
                  System.out.println("Ungültige Auswahl.");
              }
          } catch (Exception e){
              System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
              storZurYoN(scanner, storZur);
          }
    }
     static void storZur(Scanner scanner, Book storZur) {
        Book books = new Book();
         try {
             System.out.println("die Bestellungen stornieren (s) oder eine Buch löschen (l)?: ");

             char zurueckStor = scanner.nextLine().charAt(0);

             if (zurueckStor == 's') {
                 Book.warenkorb.bookList.clear();

                 System.out.println("Die Auswahl der Bücher wurde storniert.");
                 books.menu();
             } else if (zurueckStor == 'l') {
                 zurueksetzen(scanner, storZur);
             }
         } catch (Exception e){
             System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
             storZur(scanner, storZur);
         }

    }
     static void zurueksetzen(Scanner scanner, Book storZur) {
         try {
             int anzahlGekaufteBuecher = 0;
             System.out.print("Welches Buch möchten Sie zurücksetzen? Geben Sie die index des Buchs ein: ");
             int buchNummer = scanner.nextInt();
            scanner.nextLine();
             if (buchNummer >= 1 && buchNummer <= Book.warenkorb.bookList.size()) {
                 Book loschendesBuch = Book.warenkorb.bookList.remove(buchNummer - 1);
                 storZur.gesamtPreis -= loschendesBuch.preis;
                 System.out.println("Das Buch '" + loschendesBuch.genres + "' wurde zurückgesetzt.");
                 System.out.println("\nRestliche Bücher: ");
                 for (Book buch : Book.warenkorb.bookList) {
                     System.out.println(buch);
                 }
                 Book.warenkorb.show();
             }
         } catch (Exception e) {
             System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
             zurueksetzen(scanner, storZur);
         }
     }
}
