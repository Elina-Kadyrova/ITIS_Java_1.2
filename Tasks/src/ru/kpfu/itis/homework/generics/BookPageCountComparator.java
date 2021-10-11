package ru.kpfu.itis.homework.generics;

import java.util.Comparator;

public class BookPageCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPageCount() > b2.getPageCount()? 1 : (b1.getPageCount() < b2.getPageCount()? -1 : 0);
    }
}
