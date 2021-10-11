package ru.kpfu.itis.homework.generics;

import java.util.Comparator;

public class BookPriceComparator implements Comparator <Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPrice() > b2.getPrice()? 1 : (b1.getPrice() < b2.getPrice()? -1 : 0);
    }
}
