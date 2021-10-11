package ru.kpfu.itis.homework.collections;

import java.util.*;

public class ModifiableCollection<T> extends AbstractCollection<T> {

    public static void main(String[] args) {
        ModifiableCollection <Integer> col = new ModifiableCollection();
    }

    private final static int DEFAULT_SIZE = 10;
    private int size;
    private T[] data;

    public ModifiableCollection() {
        data = (T[]) new Object[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
    }

    public ModifiableCollection(Collection<? extends T> col){
        data = (T[]) new Object[col.size()];
        size = 0;
        for (T el: col){
            data[size] = el;
            size++;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifiableCollection ts = (ModifiableCollection) o;
        return size == ts.size &&
                Arrays.equals(data, ts.data);
    }

    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator(data);
    }

    @Override
    public int size() {
        return size;
    }

    public boolean add(T el){
        if(size >= data.length){
            java.lang.Object[] newData = (T[])new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = (T[])newData;
        }
        data[size] = el;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        Iterator <T> iter = this.iterator();
        while(iter.hasNext()){
            if (iter.next().equals(o)){
                iter.remove();
                return true;
            }
        }
        return false;
    }

}

