package main.one;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        try{
            reader = new BufferedReader(new InputStreamReader(new DataInputStream(
                    new FileInputStream(
                            "C:\\KFU\\ITIS2sem\\Informatics\\ExamPreparation\\JustJava\\src\\main\\one\\input.txt"))));
            String data;
            while ((data = reader.readLine()) != null){
                String[] tmp = data.split(" ");//Split space
                int key;
                for(String s: tmp) {
                    key = Integer.valueOf(s);
                    Integer frequency = hashMap.get(key);
                    hashMap.put(key, frequency == null ? 1 : frequency + 1);
                }
            }
            reader.close();
            printing(hashMap);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printing(HashMap map){
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> el: set){
            System.out.println(el.getKey() + " : " + el.getValue() + " раз");

        }
    }
}
