package ru.kpfu.itis.homework.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;

public class XMLWriter extends Writer {
    private FileWriter fileWriter;
    private OutputStream out;

    public XMLWriter(Writer writer) {
        this.fileWriter = (FileWriter) writer;
    }

    public XMLWriter(FileWriter fileWriter, OutputStream out) {
        this.fileWriter = fileWriter;
        this.out = out;
    }

    public void writeProducts(ArrayList<Product> products) throws IOException{

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
}
