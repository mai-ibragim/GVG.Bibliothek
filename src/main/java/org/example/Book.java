package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Bestellaenderung.storZurYoN;

@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public String genres;
    private String autor;
    private int jahr;
    public int preis;

    private List<Book> buchliste = new ArrayList<>();

    int gesamtPreis = 0;
    List<Book> gekaufteBuecher = new ArrayList<>();



    public Book(String genres, String autor, int jahr, int preis) {
        this.genres = genres;
        this.autor = autor;
        this.jahr = jahr;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return genres + " - " + autor + " (" + jahr + ") - " + preis + " EUR";
    }
     static void buchliste(Book storZur) {
        Scanner scanner = new Scanner(System.in);

        storZur.buchliste.add(new Book("1. Roman", "Müller", 2005, 25));
        storZur.buchliste.add(new Book("2. Roman", "Meister", 2010, 19));
        storZur.buchliste.add(new Book("3. Abenteuer", "Schmidt", 2015, 32));
        storZur.buchliste.add(new Book("4. Abenteuer", "Meyer", 2019, 45));
        storZur.buchliste.add(new Book("5. Krimi", "Koch", 2020, 32));
        storZur.buchliste.add(new Book("6. Komödie", "Molf", 2015, 13));
        storZur.buchliste.add(new Book("7. Thriller", "Bauer", 2016, 24));

        System.out.println("Hier ist die Liste der Bücher: ");
        for (Book buch : storZur.buchliste) {
            System.out.println(buch);
        }
        storZur.auswahl(storZur);

        System.out.println("\nGekaufte Bücher: ");
        for (Book buch : storZur.gekaufteBuecher) {
            System.out.println(buch);
        }
        storZurYoN(scanner, storZur);
    }
    void auswahl(Book storZur) {
        try {
            Scanner scanner = new Scanner(System.in);
            char choice = 'y';
            while (choice == 'y') {
                System.out.print("\nWähle ein Buch zwischen 1 und 7 aus: ");
                int auswahl = scanner.nextInt();
                scanner.nextLine();

                if (auswahl >= 1 && auswahl <= buchliste.size()) {
                    gekaufteBuecher.add(buchliste.get(auswahl - 1));
                   choice = orderMore(scanner, storZur);
                } else{
                    System.out.println("Ungültige Auswahl. Bitte wählen Sie zwischen 1 und " + buchliste.size());
                }
            }
        } catch (Exception e){
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus.");
            auswahl(storZur);
        }
    }
      static void menuDe() {
          Scanner scanner = new Scanner(System.in);
          Book books = new Book();
          Login login = new Login();
          Language language = new Language();
          try {
              System.out.println("\nSTARTSEITE\n");

              System.out.println("1. Buchliste\n" +
                      "2. Sprache auswählen\n" +
                      "3. Passwort ändern\n" +
                      "4. Ausloggen");

              int choice = scanner.nextInt();
              switch (choice) {
                  case 1:
                      books.buchliste(books);
                      break;
                  case 2:
                      language.menuSprache(scanner);
                      break;
                  case 3:
                      login.changePass();
                      break;
                  case 4:
                      login.ausloggen();
                      break;
                  default:
                      System.out.println("Die Auswahl ist nicht gültig.");
                      break;
              }

          } catch (Exception e) {
              System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
              menuDe();
          }
      }
    private char orderMore(Scanner scanner, Book storZu) {
        Bestellaenderung bestell = new Bestellaenderung();
        char choice;
        System.out.println("Möchten Sie noch Bücher kaufen? (y/n): ");
        choice = scanner.nextLine().charAt(0);

        if (choice == 'y') {
            System.out.println("Hier ist die Liste der Bücher: ");
            for (Book buch : buchliste) {
                System.out.println(buch);
            }
        } else if (choice == 'n') {
            bestell.storZurYoN(scanner, storZu);
        }
        return choice;
    }
}



