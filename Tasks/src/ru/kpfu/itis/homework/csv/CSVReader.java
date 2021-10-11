package ru.kpfu.itis.homework.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;

public class CSVReader extends Reader{
    private BufferedReader bufferedReader;
    private InputStream in;

    public CSVReader(Reader reader) {
        this.bufferedReader = (BufferedReader) reader;
    }

    public CSVReader(BufferedReader bufferedReader, InputStream in) {
        this.bufferedReader = bufferedReader;
        this.in = in;
    }

    public String[][] readData(ArrayList<String> data) throws IOException{
        String separator = "";
        while ((separator = bufferedReader.readLine()) != null){
            data.add(separator);
        }
        String[][] stringArray = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            stringArray[i] = data.get(i).split(",");
        }
        return stringArray;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return in.read(new byte[]{Byte.parseByte(String.valueOf(cbuf))}, off, len);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }
}
