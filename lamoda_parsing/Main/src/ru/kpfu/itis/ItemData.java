package ru.kpfu.itis;

import java.util.Objects;

public class ItemData {
    private String reference;
    private String price;
    private String name;

    public ItemData(String name, String price, String reference) {
        this.name = name;
        this.price = price;
        this.reference = reference;
    }

    public ItemData() {
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name of product: " + name + '\n' +
                "Price: " + price + '\n' +
                "Reference: " + reference + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemData itemData = (ItemData) o;
        return Objects.equals(name, itemData.name) &&
                Objects.equals(reference, itemData.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, reference);
    }
}
