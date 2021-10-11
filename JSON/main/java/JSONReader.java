import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReader extends Reader {
    private FileReader fileReader;
    private InputStream in;

    public JSONReader(Reader reader) {
        this.fileReader = (FileReader) reader;
    }

    public JSONReader(FileReader fileReader, InputStream in) {
        this.fileReader = fileReader;
        this.in = in;
    }

    public ArrayList<Product> readProducts(ArrayList<String> data) throws IOException{
        ArrayList<Product> products = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        products = gson.fromJson(fileReader, ArrayList.class);

        return products;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return in.read(new byte[]{Byte.parseByte(String.valueOf(cbuf))}, off, len);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }
}

