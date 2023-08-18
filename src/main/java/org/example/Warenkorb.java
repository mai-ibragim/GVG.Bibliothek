package org.example;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {

    List<Book> bookList = new ArrayList<>();



    void addBook(Book book){

        bookList.add(book);

    }

    int getPrice(){
        int price = 0;

        for (Book book : bookList) {
            price+=book.preis;
        }
       return price;
    }

    void removeBook(Book book){

        bookList.remove(book);
    }

    public int getAmount() {
        return bookList.size();
    }
    void show(){
        System.out.println("\nGesamtanzahl im Warenkorb: " + this.getAmount());
        System.out.println("\nBücher im Warenkorb: ");
        for (Book buch : this.bookList) {
            System.out.println(buch);
        }
        System.out.println("Gesamtpreis: " + this.getPrice() + " EUR");
    }
}
