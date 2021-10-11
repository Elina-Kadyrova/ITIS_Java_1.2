import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ProductsInputStream extends DataInputStream {
    private DataInputStream in;

    public ProductsInputStream(DataInputStream in) {
        super(in);
        this.in = in;
    }

    public Product readProduct() throws IOException {
        try {
            String name = in.readUTF();
            double price = in.readDouble();
            int count = in.readInt();
            Product newProduct= new Product(name, price, count);
            System.out.println(newProduct.toString());
            return newProduct;
        }
        catch (IOException ex){
            throw new IOException(" ");
        }
    }

    public ArrayList<Product> readProducts(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            while(in.available() > 0){
                products.add(readProduct());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsInputStream that = (ProductsInputStream) o;
        return Objects.equals(in, that.in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in);
    }
}
