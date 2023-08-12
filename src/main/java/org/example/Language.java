package org.example;

import java.util.Scanner;

public class Language {

    static void menuSprache(Scanner scanner) {
        Book book = new Book();
        try {
            System.out.println("Wählen Sie eine Zahl aus, um die  Sprache des Starseite zu ändern: \n" +
                    "1. Deutsch\n2. English\n3. Русский\n4. Кыргызча");
            int sprachewahl = scanner.nextInt();
            switch (sprachewahl) {
                case 1:
                    System.out.println("Sie haben deutsche die Sprache ausgewählt.");
                    if (sprachewahl == 1){

                    }
                    break;
                case 2:
                    System.out.println("You have selected English language.");
                    break;
                case 3:
                    System.out.println("Вы выбрали русский язык.");
                    break;
                case 4:
                    System.out.println("Сиз кыргыз тилин тандадыңыз.");
                    break;
                default:

            }
        } catch (Exception e) {
            System.out.println("Es ist schiefgelaufen. Probieren Sie noch mal aus." + e.getMessage());
            menuSprache(scanner);
        }
        book.menuDe();
    }
}
