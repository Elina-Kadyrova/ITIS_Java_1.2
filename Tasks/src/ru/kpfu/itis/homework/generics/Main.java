package ru.kpfu.itis.homework.generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        Book b1 = new Book("Pride and Prejudice", "Jane Austen", 383, 245);
        books.add(b1);
        Book b2 = new Book("1984", "GeorgeOrwell", 319, 286);
        books.add(b2);
        Book b3 = new Book("Three Comrades", "Erich Maria Remarque", 479, 331);
        books.add(b3);

        System.out.println(b2.compareTo(b1));
        System.out.println(b2.compareTo(b2));
        System.out.println(b2.compareTo(b3));

        BookPageCountComparator bookPageCountComparator = new BookPageCountComparator();
        System.out.println(bookPageCountComparator.compare(b1,b2));
        System.out.println(bookPageCountComparator.compare(b1,b3));

        BookPriceComparator bookPriceComparator = new BookPriceComparator();
        System.out.println(bookPriceComparator.compare(b2,b1));
        System.out.println(bookPriceComparator.compare(b2,b3));

    }
}
