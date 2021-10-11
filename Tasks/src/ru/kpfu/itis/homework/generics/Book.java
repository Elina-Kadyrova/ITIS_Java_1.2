package ru.kpfu.itis.homework.generics;
import java.lang.Comparable;

public class Book implements Comparable<Book> {
    private String name;
    private String author;
    private int pageCount;
    private int price;

    public Book(String name, String author, int pageCount, int price) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Book b) {
        if (this.getPrice() < b.getPrice()) {
            return -1;
        }
        else {
            if (this.getPrice() > b.getPrice()) {
                return 1;
            }
            else
                if (this.getPageCount() < b.getPageCount()){
                    return -1;
                }
                else {
                    if (this.getPageCount() > b.getPageCount()) {
                        return 1;
                    }
                    else
                        return 0;
                }
        }
    }
}
