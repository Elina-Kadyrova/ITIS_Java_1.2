package ru.kpfu.itis.homework.InputStreamProducts;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ProductsOutputStream extends DataOutputStream {
    private DataOutputStream out;

    public ProductsOutputStream(DataOutputStream out) {
        super(out);
        this.out = out;
    }

    public void writeProduct(Product product) {
        try{
            out.writeUTF(product.getName());
            out.writeDouble(product.getPrice());
            out.writeInt(product.getCount());
            System.out.println("File has been written.");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeProducts(ArrayList<Product> products){
        for (int i = 0; i < products.size(); i++) {
            writeProduct(products.get(i));
        }
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte b[]) throws IOException{
        out.write(b);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException{
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException{
        out.flush();
    }

    @Override
    public void close() throws IOException{
        out.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsOutputStream that = (ProductsOutputStream) o;
        return Objects.equals(out, that.out);
    }

    @Override
    public int hashCode() {
        return Objects.hash(out);
    }

}
