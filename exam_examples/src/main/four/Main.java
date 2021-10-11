package main.four;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        task1(new String[]{"asdfg", "gjfonb", "ahfiikfb", "asd"});
        System.out.println();
        task2(new Integer[]{123, 233, 3443, 555, 6666, 25, 26});
        System.out.println();
        task3("C:\\KFU\\ITIS2sem\\Informatics\\ExamPreparation\\JustJava\\src\\main\\four\\task3.txt");
    }

    private static void task1(String[] input) {
        Arrays.stream(input).filter(s -> s.startsWith("a")).
                sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);
    }

    private static void task2(Integer[] input) {
        Arrays.stream(input).sorted((a, b) -> Integer.compare(a % 10, b % 10)).
                map(x -> x / 10).distinct().forEach(System.out::println);
    }

    private static void task3(String path) {
        Map<String, Integer> map = new HashMap<>();
        try {
            var stringListMap = Files.lines(Paths.get(path)).map(x -> x.split("[|]")).
                    collect(Collectors.groupingBy(x -> x[0]));
            Set<String> keySet = stringListMap.keySet();
            for (String key : keySet) {
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + Integer.parseInt(stringListMap.get(key).get(0)[1]));
                } else map.put(key, Integer.parseInt(stringListMap.get(key).get(0)[1]));
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

