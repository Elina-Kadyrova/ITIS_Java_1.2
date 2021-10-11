package ru.kpfu.itis.homework.InputStreamProducts;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String name;
    private double price;
    private int count;

    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        if (nameIsCorrect(name)){
            this.name = name;
        }
        else{
            System.out.println("Incorrect name of product");
        }
    }
    
    private boolean nameIsCorrect(String name){
        if (name.length() != 5){
            return false;
        }
        return true;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                count == product.count &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, count);
    }

    @Override
    public String toString() {
        return "name = " + name +
                " price = " + price +
                " count = " + count;
    }
}
