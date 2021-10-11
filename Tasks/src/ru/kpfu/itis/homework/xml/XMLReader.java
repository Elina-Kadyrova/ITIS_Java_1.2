package ru.kpfu.itis.homework.xml;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;

public class XMLReader extends Reader {
    private FileReader fileReader;
    private InputStream in;

    public XMLReader(Reader reader) {
        this.fileReader = (FileReader) reader;
    }

    public XMLReader(FileReader fileReader, InputStream in) {
        this.fileReader = fileReader;
        this.in = in;
    }

    public ArrayList<Product> readProducts() throws IOException{
        ArrayList<Product> products = new ArrayList<>();


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
