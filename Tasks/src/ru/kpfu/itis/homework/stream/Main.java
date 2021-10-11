package ru.kpfu.itis.homework.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1(){
        try {
            Stream<String> stream1 =
                    Files.lines(Paths.get("C:/KFU/ITIS2sem/Informatics/Tasks/Tasks/someTextHere.txt"))
                            .flatMap(s -> Stream.of(s.split(" ")))
                            .filter(x -> x.length() % 2 != 0);
            System.out.println("stream 1 = " + stream1.collect(Collectors.toList()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void task3(){
        try {
            Stream<Object> stream3 =
                    Files.lines(Paths.get("C:/KFU/ITIS2sem/Informatics/Tasks/Tasks/someTextHere.txt"))
                            .flatMap(s -> Stream.of(s.split(" ")))
                            .map(String::length);
            System.out.println("stream 3 = " + stream3.collect(Collectors.toList()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void task2(){
        Random random = new Random();
        long stream = random.ints(100, 0, 1000000).filter(x -> String.valueOf(x).length() % 2 == 0).count();
        System.out.println(stream);
    }

    public static Integer numberOfDischarges(Integer x){
        int amount= 0;
        while (x > 0){
            x /= 10;
            amount++;
        }
        return amount;
    }

   /* private static List<Integer> randomIntsGenerator() {
        return new Random()
                .ints(10, 1, 1000000)
                .boxed()
                .collect(Collectors.toList());
    }*/

    public static void task4(){
        try {
            ComparatorT comp = new ComparatorT();
            Stream<String> stream4 =
                    Files.lines(Paths.get("C:/KFU/ITIS2sem/Informatics/Tasks/Tasks/someTextHere.txt"))
                            .flatMap(s -> Stream.of(s.split(" ")))
                            .sorted(comp);
            System.out.println("stream 4 = " + stream4.collect(Collectors.toList()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ComparatorT implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
