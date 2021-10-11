package ru.kpfu.itis.homework.InputStreamProducts;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class ProductReader extends Reader {
    InputStream fis;

    public ProductReader(InputStream fis) {
        this.fis = fis;
    }

    public double readDouble(){
        return 0;
    }

    public int readInt(){
        return 0;
    }

    public String readString(){
        return null;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return fis.read(new byte[]{Byte.parseByte(String.valueOf(cbuf))}, off, len);
    }

    @Override
    public void close() throws IOException {
        fis.close();
    }
}
