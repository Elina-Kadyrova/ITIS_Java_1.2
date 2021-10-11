package ru.kpfu.itis.homework.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        outputNumberFile(n);
        inputNumberFile();

    }

    public static void outputNumberFile(int n){
        try (FileOutputStream fos = new FileOutputStream("C:\\KFU\\ITIS2sem\\Informatics\\для файлового менеджера\\4.txt")) {
            fos.write(n >> 24);
            fos.write(n >> 16);
            fos.write(n >> 8);
            fos.write(n >> 0);

            fos.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void inputNumberFile(){
        try (FileInputStream fis = new FileInputStream("C:\\KFU\\ITIS2sem\\Informatics\\для файлового менеджера\\4.txt")) {
            int c1 = fis.read();
            int c2 = fis.read();
            int c3 = fis.read();
            int c4 = fis.read();

            System.out.println(c1 << 24);
            System.out.println(c2 << 16);
            System.out.println(c3 << 8);
            System.out.println(c4 << 0);
            System.out.println();
            System.out.println((c1 << 24) | (c2 << 16) | (c3 << 8) | (c4 << 0));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
