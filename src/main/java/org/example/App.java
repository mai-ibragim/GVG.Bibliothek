package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {

            Login login = new Login();

            System.out.println("\nHerzlich Willkommen zur Bibliothek!\n");

            while (true) {
                login.account();
            }
        }
    }



