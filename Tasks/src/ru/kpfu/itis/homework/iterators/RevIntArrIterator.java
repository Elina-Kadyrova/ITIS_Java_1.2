package ru.kpfu.itis.homework.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RevIntArrIterator implements Iterator<Integer> {
    private Integer[] arr;
    private int cur;

    public RevIntArrIterator(Integer[] arr) {
        this.arr = arr;
        this.cur = arr.length - 1;
    }

    @Override
    public boolean hasNext() {
        return cur >= 0;
    }

    @Override
    public Integer next() {
        if (cur >= 0) {
            return arr[cur--];
        }
        else
            throw new NoSuchElementException("There is no next element");
    }
}
