package ru.kpfu.itis.homework.sortedset;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        Collection<Integer> col2 = new ArrayList<Integer>();
        col1.add(new Integer(24));
        col1.add(67);
        col1.add(3);
        col1.add(8956);
        col1.add(45);
        System.out.println(col1);
        col2.add(78);
        col2.add(9);
        col2.add(67);
        col2.add(7845);
        System.out.println(col2);

        IntegerComparator comp = new IntegerComparator();
        MySortedSet<Integer> set1 = new MySortedSet(col1, comp);
        MySortedSet<Integer> set2 = new MySortedSet<>(comp);
        Integer a = 698;
        set2.add(9);
        set2.print();

        System.out.println(set1.isEmpty());
        System.out.println(set1.size());
        System.out.println(set1.comparator());
        System.out.println(set1.iterator());
        System.out.println(set1.toString());
    }
}
