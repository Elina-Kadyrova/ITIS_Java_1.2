import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;

public class JSONWriter extends Writer {
    private FileWriter fileWriter;
    private OutputStream out;

    public JSONWriter(Writer writer) {
        this.fileWriter = (FileWriter) writer;
    }

    public JSONWriter(FileWriter fileWriter, OutputStream out) {
        this.fileWriter = fileWriter;
        this.out = out;
    }

    public void writeProducts(ArrayList<Product> products) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String json = gson.toJson(products);
        fileWriter.write(json);
        fileWriter.flush();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        out.write(new byte[]{Byte.parseByte(String.valueOf(cbuf))}, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }
}

