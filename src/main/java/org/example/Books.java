package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Bestellaenderung.storZurYoN;

@NoArgsConstructor
@AllArgsConstructor
public class Books {

    public String genres;
    private String autor;
    private int jahr;
    public int preis;

    private List<Books> buchliste = new ArrayList<>();

    int gesamtPreis = 0;
    List<Books> gekaufteBuecher = new ArrayList<>();


    public Books(String genres, String autor, int jahr, int preis) {
        this.genres = genres;
        this.autor = autor;
        this.jahr = jahr;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return genres + " - " + autor + " (" + jahr + ") - " + preis + " EUR";
    }





     static void buchliste(Books storZur) {
        Scanner scanner = new Scanner(System.in);

        storZur.buchliste.add(new Books("1. Roman", "Müller", 2005, 25));
        storZur.buchliste.add(new Books("2. Roman", "Meister", 2010, 19));
        storZur.buchliste.add(new Books("3. Abenteuer", "Schmidt", 2015, 32));
        storZur.buchliste.add(new Books("4. Abenteuer", "Meyer", 2019, 45));
        storZur.buchliste.add(new Books("5. Krimi", "Koch", 2020, 32));
        storZur.buchliste.add(new Books("6. Komödie", "Molf", 2015, 13));
        storZur.buchliste.add(new Books("7. Thriller", "Bauer", 2016, 24));

        System.out.println("Hier ist die Liste der Bücher: ");
        for (Books buch : storZur.buchliste) {
            System.out.println(buch);
        }

        storZur.auswahl();

        System.out.println("\nGekaufte Bücher: ");
        for (Books buch : storZur.gekaufteBuecher) {
            System.out.println(buch);
        }
        storZurYoN(scanner, storZur);
    }





    void auswahl() {
        Scanner scanner = new Scanner(System.in);
        Books books = new Books();
        Berechnung berechnung = new Berechnung();
        char choice = 'y';

        while (choice == 'y') {
            System.out.print("\nWähle ein Buch zwischen 1 und 7 aus: ");
            int auswahl = scanner.nextInt();
            scanner.nextLine();

            if (auswahl >= 1 && auswahl <= buchliste.size()) {
                gekaufteBuecher.add(buchliste.get(auswahl - 1));

                System.out.println("Möchten Sie noch Bücher bestellen? (y/n): ");
                choice = scanner.nextLine().charAt(0);
                if (choice == 'y') {
                    System.out.println("Hier ist die Liste der Bücher: ");
                    for (Books buch : buchliste) {
                        System.out.println(buch);
                    }
                } else {
                    System.out.println("Ungültige Auswahl. Bitte wählen Sie zwischen 1 und 7" + buchliste.size());
                }
            }
            books.menu();
        }
    }




   //*******************************MENU**********************************************





      void menu(){
          Scanner scanner = new Scanner(System.in);
        Books books = new Books();
        Login login = new Login();
        System.out.println("STARTSEITE\n");
        System.out.println("1. Buchliste\n" +
                "2. Passwort ändern\n" +
                "3. Ausloggen");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
               books.buchliste(books);
               break;
            case 2:
                login.changePass();
                buchliste(books);
                break;
            case 3:
                login.ausloggen();
                break;
            default:
                System.out.println("Die Auswahl ist nicht gültig.");
                break;
        }
    }
}



