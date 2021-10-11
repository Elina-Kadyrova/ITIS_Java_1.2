import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Sugar", 78.68, 5);
        Product product2 = new Product("Water", 33.4, 477);
        Product product3 = new Product("Juice", 34.943, 1);

        ArrayList<Product> productArraylistOutput = new ArrayList<>();
        productArraylistOutput.add(product1);
        productArraylistOutput.add(product2);
        productArraylistOutput.add(product3);

        try{
            ProductsOutputStream productsOutputStream = new ProductsOutputStream(new DataOutputStream
                    (new FileOutputStream("products.txt")));
            productsOutputStream.writeProducts(productArraylistOutput);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try{
            ProductsInputStream productsInputStream = new ProductsInputStream(new DataInputStream
                    (new FileInputStream("products.txt")));
            ArrayList<Product> newArr = productsInputStream.readProducts();
            newArr.toString();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
