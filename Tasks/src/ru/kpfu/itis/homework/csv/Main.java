package ru.kpfu.itis.homework.csv;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\KFU\\ITIS2sem\\Informatics\\Tasks\\test.csv";

        String[][] dataArray = {{"id", "name", "points"},{"1", "Petya", "5"}, {"2", "Kolya", "12"}, {"3", "Vanya", "8"}};
        CSVWriter writer;
        try{
            writer = new CSVWriter(new BufferedWriter(new FileWriter(fileName)));
            writer.writeData(dataArray);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<String> data = new ArrayList<>();
        String[][] result = new String[data.size()][];
        CSVReader reader;
        try{
            reader = new CSVReader(new BufferedReader(new FileReader(fileName)));
            result = reader.readData(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
