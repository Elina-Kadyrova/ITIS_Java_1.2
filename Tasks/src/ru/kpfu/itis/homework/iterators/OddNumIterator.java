package ru.kpfu.itis.homework.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddNumIterator implements Iterator<Integer> {
    private Integer[] arr;
    private int cur;
    private int last = -1;

    public OddNumIterator(Integer[] arr) {
        this.arr = arr;
    }

    public Integer lastOdd() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                last = i;
            }
        }
        return last;
    }

    @Override
    public boolean hasNext() {
        return cur <= lastOdd();
    }

    @Override
    public Integer next() {
        for (int i = cur; i <= lastOdd(); i++) {
            if (arr[i] % 2 != 0) {
                return arr[cur++];
            } else {
                cur++;
            }
        }
        throw new NoSuchElementException("There is no next element");
    }
}
