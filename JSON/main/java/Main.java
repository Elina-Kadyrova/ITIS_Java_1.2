import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\KFU\\ITIS2sem\\Informatics\\Tasks\\testJSOM.json";
        Product product1 = new Product("Sugar", 78.68, 5);
        Product product2 = new Product("Water", 33.4, 477);
        Product product3 = new Product("Juice", 34.943, 1);
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        JSONWriter jsonWriter;
        try{
            jsonWriter = new JSONWriter(new FileWriter(fileName));
            jsonWriter.writeProducts(productsList);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<String> data = new ArrayList<>();
        ArrayList<Product> result = new ArrayList<>();
        JSONReader jsonReader;
        try{
            jsonReader = new JSONReader(new FileReader(fileName));
            result = jsonReader.readProducts(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

