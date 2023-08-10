package org.example;

import java.util.Scanner;

public class Login {
    static Scanner scan = new Scanner(System.in);
    private  String newAccount;
    private  String account;
    private  int passwort;
     Books books = new Books();



    //**********************ACCOUNT******************************************************

    void account() {
        try {
            System.out.println("Wählen Sie eine Zahl aus: \n" +
                    "1. Ich habe breits ein Account\n" +
                    "2. Ich möchte mich neue registrieren\n" +
                    "3. Ich möchte mich als Gast anmelden");
            int account = scan.nextInt();
            switch (account) {
                case 1:
                    anmelden();
                    break;
                case 2:
                    newAccount();

                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    try {
                        System.out.println("Leider gibt es keine weitere Auswahl.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        } catch (Exception e){
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus.");
            account();
        }
    }


    //**********************ANMELDEN******************************************************

    void anmelden() {

        System.out.println("Melden Sie sich an: ");
        account = scan.next();
        System.out.println("Geben Sie ihr Passwort ein: ");
        passwort = scan.nextInt();
        books.menu();
    }



    //**********************NEW ACCOUNT******************************************************


    void newAccount() {
        System.out.println("Melden Sie sich an: ");
        newAccount = scan.next();
        System.out.println("Geben Sie ihr Passwort ein: ");
        passwort = scan.nextInt();
        books.menu();
    }


    //**********************AUSLOGGEN******************************************************


    void ausloggen(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Möchten Sie sich ausloggen oder möchten Sie noch Buchliste gucken? (y/n/b): ");
        char ausloggen = scanner.nextLine().charAt(0);

        if (ausloggen == 'y') {

            System.out.println("Sie wurden ausgeloggt.");
        } else if(ausloggen == 'n') {
            System.out.println("Aufwiedersehen!!!");
        } else if (ausloggen == 'b') {
            books.buchliste(books);
        }
        System.exit(0);
    }
    void changePass(){
        System.out.println("Geben Sie altes Passwort ein, um neues einzugeben: ");
        int oldPass = scan.nextInt();
        System.out.println("Neues Passwort: ");
        int newPass = scan.nextInt();
        System.out.println("Das Passwort wurde erfolgreich geändert.");
        anmelden();
        books.menu();
    }

}
