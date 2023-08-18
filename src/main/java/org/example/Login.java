package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    static Scanner scan = new Scanner(System.in);
    private  String newAccount;
    private  String account;
    private  String passwort;
     Book books = new Book();



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
                    books.menu();
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
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            account();
        }
    }
    void anmelden() {
        try {
            System.out.println("Melden Sie sich an: ");
            account = scan.next();
            String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(account);
            if (matcher.matches()) {
                pass();

            } else {
                System.out.println("Die eingegebene E-Mail-Adresse ist ungültig.");
                anmelden();
            }
        } catch (Exception e){
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            anmelden();
        }
    }
    void pass() throws InterruptedException {
        try {
        Scanner scanner = new Scanner(System.in);
        int versuch = 3;
        int falschPass = versuch;

        String correctPassword = "Bibliothek";
        boolean authentifiziert = false;

        while (falschPass > 0 && !authentifiziert) {
            System.out.print("Geben Sie das Passwort ein: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(correctPassword)) {
                authentifiziert = true;
                System.out.println("Anmeldung erfolgreich!");
                books.menu();
            } else {
                falschPass--;
                if (falschPass > 0) {
                    System.out.println("Falsches Passwort. Verbleibende Versuche: " + falschPass);
                } else {
                    System.out.println("Zu viele fehlgeschlagene Versuche. Bitte warten Sie 1 Minute.");
                    Thread.sleep(60000);
                    falschPass = versuch;
                    pass();
                }
            }
        }
    } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            pass();
        }
    }
    void newPass() {
        try {
            int versuch = 3;
            while (versuch > 0) {
                System.out.print("Geben Sie ein Passwort ein: ");
                passwort = scan.nextLine();
                System.out.print("Bestätigen Sie das Passwort: ");
                String confirmPassword = scan.nextLine();

                if (passwort.equals(confirmPassword)) {
                    System.out.println("Registrierung erfolgreich!");
                    books.menu();
                } else {
                    versuch--;
                    if (versuch > 0) {
                        System.out.println("Die eingegebenen Passwörter stimmen nicht überein. " +
                                "Verbleibende Versuche: " + versuch);
                    } else {
                        System.out.println("Versuchen Sie später noch mal aus.");
                        newAccount();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            newPass();
        }
    }
    void newAccount() {
        try {
            System.out.println("Geben Sie gültige E-Mail Adresse ein: ");
            newAccount = scan.next();
            String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(newAccount);
            if (matcher.matches()) {
                newPass();
            } else {
                System.out.println("Die eingegebene E-Mail-Adresse ist ungültig.");
                newAccount();
            }
        } catch (Exception e){
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            newAccount();
        }
    }
    void ausloggen(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Bestätigen Sie bitte mit (y), um auszuloggen: ");
            char ausloggen = scanner.nextLine().charAt(0);

            if (ausloggen == 'y') {

                System.out.println("Sie wurden ausgeloggt.");
            }
            System.exit(0);
            System.out.println("\nAufwiedersehen!!!");
        } catch (Exception e){
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            ausloggen();
        }
    }
    void changePass() {
        int versuch = 3;
        try {
                System.out.println("Geben Sie altes Passwort ein: ");
                passwort = scan.nextLine();
                if(passwort.equals("Bibliothek")) {
                    while (versuch > 0) {
                    System.out.print("Geben Sie neues Passwort ein: ");
                    passwort = scan.nextLine();
                    System.out.print("Bestätigen Sie das Passwort: ");
                    String confirmPassword = scan.nextLine();
                    if (passwort.equals(confirmPassword)) {
                    System.out.println("Erfolgreich!");
                    books.menu();
                    } else {
                    versuch--;
                    if (versuch > 0) {
                        System.out.println("Die eingegebenen Passwörter stimmen nicht überein. " +
                                "Verbleibende Versuche: " + versuch);
                    } else {
                        System.out.println("Versuchen Sie später noch mal aus.");
                       changePass();
                    }
                }
            }
                } else {
                    System.out.println("Sie haben altes Passwort falsch eingegeben. Versuchen Sie noch mal.");
                    changePass();
                }
            } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            changePass();
        }
    }
}
