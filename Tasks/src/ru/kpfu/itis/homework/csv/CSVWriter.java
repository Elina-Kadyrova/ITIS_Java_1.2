package ru.kpfu.itis.homework.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class CSVWriter extends Writer {
    private BufferedWriter bufferedWriter;
    private OutputStream out;

    public CSVWriter(Writer writer) {
        this.bufferedWriter = (BufferedWriter) writer;
    }

    public CSVWriter(BufferedWriter bufferedWriter, OutputStream out) {
        this.bufferedWriter = bufferedWriter;
        this.out = out;
    }

    public void writeData(String[][] arrayData) throws IOException{
        for (int i = 0; i < arrayData.length; i++) {
            for (int j = 0; j < arrayData[i].length; j++) {
                bufferedWriter.write(arrayData[i][j]);
                if (j != arrayData[i].length - 1){
                    bufferedWriter.write(",");
                }
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
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

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }
}
