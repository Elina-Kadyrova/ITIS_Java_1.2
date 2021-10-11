package ru.kpfu.itis.homework.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileInStream = null;
        try {
            fileInStream = new FileInputStream("C:\\KFU\\ITIS2sem\\Informatics\\Tasks\\123456.txt");
            int a = -1;
            while ((a = fileInStream.read()) != -1) {
                System.out.println(a);
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try{
            fileInStream.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
