package ru.kpfu.itis.homework.InputStreamProducts;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

public class ProductWriter extends Writer {
    FileOutputStream fos;

    public ProductWriter(FileOutputStream fos) {
        this.fos = fos;
    }

    public void writeProduct(Product product){

    }

    public void writeDouble(double num) throws IOException{

    }

    public void writeInt(int num) throws IOException{
        for (int i=24; i >= 0; i-=8) {
            fos.write(num>>i);
        }
        fos.flush();
    }

    public void writeString(String string) throws IOException{
        try {
            for (int i = 0; i < string.length(); i++) {
                fos.write(string.charAt(i));
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fos.write(new byte[]{Byte.parseByte(String.valueOf(cbuf))}, off, len); //???
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }
}
