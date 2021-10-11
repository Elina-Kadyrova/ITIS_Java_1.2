package ru.kpfu.itis.homework.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericIterator<T> implements Iterator<T> {
    private T[] arr;
    private int cur;

    public GenericIterator(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return cur < arr.length;
    }

    @Override
    public T next() {
        if (cur < arr.length) {
            return arr[cur++];
        }
        else
            throw new NoSuchElementException("There is no next element");
    }

}
