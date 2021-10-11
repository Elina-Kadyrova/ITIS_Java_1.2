package main.five;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((o1,o2) -> Integer.compare(o1.length(), o2.length()));

        treeSet.add("pineapple");
        treeSet.add("apple");
        treeSet.add("orange");

        for (String str : treeSet) {
            System.out.println(str);
        }
        System.out.println();

        Integer[] ar = new Integer[]{1, 2, 3};
        Integer[] sorted = arraySort(ar, x -> x > 1);

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }

    private static Integer[] arraySort(Integer[] array, Predicate<Integer> predicate) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : array) {
            if (predicate.test(i)) {
                list.add(i);
            }
        }
        return list.toArray(new Integer[0]);
    }
}

