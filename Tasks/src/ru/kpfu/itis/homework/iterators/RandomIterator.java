package ru.kpfu.itis.homework.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomIterator implements Iterator<Integer> {
    private Integer[] arr;
    private int cur;
    private int num;
    private final int AMOUNT = 10;

    public RandomIterator(Integer[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return cur < AMOUNT;
    }

    @Override
    public Integer next() {
        if (cur < AMOUNT) {
            cur++;
            return arr[(int) ((Math.random() * (arr.length)))];
        }
        else
            throw new NoSuchElementException("There is no next element");
    }
}
