package ru.kpfu.itis.homework.sortedset;

import ru.kpfu.itis.homework.collections.CollectionIterator;
import java.util.*;

public class MySortedSet<T> extends AbstractSet<T> implements SortedSet<T> {
    private T[] data;
    private int size = 0;
    private int capacity = 10;
    private Comparator<T> comparator;

    public MySortedSet(Comparator<T> com) {
        data = (T[]) new Object[capacity];
        comparator = com;
        size = 0;
    }

    public MySortedSet(Collection <? extends T> col, Comparator<T> com) {
        data = (T[]) new Object[col.size()];
        comparator = com;
        addAll(col);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (data.length == 0){
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
       if (o == null){
           throw new NullPointerException("The specified element is null");
       }
       for(T el: data){
           if (o.equals(el)){
               return true;
           }
       }
       return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator<T>(data);
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[data.length];
        CollectionIterator<T> it = (CollectionIterator<T>) iterator();
        int k = 0;
        while (it.hasNext()) {
            elements[k] = (Object) it.next();
            k++;
        }
        return elements;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null){
            throw new NullPointerException("The specified array is null");
        }
        int k = 0;
        Iterator <T> iter = (Iterator<T>) this.iterator();
        if (a.length < data.length) {
            while (iter.hasNext()) {
                a[k] = iter.next();
                k++;
            }
            return a;
        }
        else {
            T[] elements = (T[]) new Object[a.length];
            while (iter.hasNext()) {
                elements[k] = iter.next();
                k++;
            }
            return elements;
        }
    }

    public boolean remove(Object o) {
        Iterator<T> iter = this.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(o)) {
                iter.remove();
                size--;
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean add(T e) {
        if (e == null){
            throw new NullPointerException("The specified element is null");
        }
        if(contains(e)){
            return false;
        }
        if(size >= capacity){
            increase();
        }
        data[size++] = e;
        Arrays.sort(data,0, size,comparator);
        return true;
    }

    public void increase(){
        T[] newData = (T[])new Object[capacity * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = (T[])newData;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
            for (T el : c) {
                if (!add(el)){
                    result = false;
                }
            }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        Iterator<T> iter = this.iterator();
        while (iter.hasNext()){
            T temp = iter.next();
            if (contains(temp)){
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null){
            throw new NullPointerException("Set contains a null element and the specified collection does not permit" +
                    "null elements or if the specified collection is null");
        }
        boolean result = false;
        for (java.lang.Object el: c){
            if (!contains(el)){
                remove(el);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null){
            throw new NullPointerException("Set contains a null element and the specified collection does not permit" +
                    "null elements or if the specified collection is null");
        }
        boolean result = false;
        for (java.lang.Object el: c){
            if (contains(el)){
                remove(el);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        int k = size - 1;
        while (!isEmpty()){
            remove(data[k]);
            k--;
        }
    }
    
    @Override
    public Comparator<? super T> comparator() {
        return (Comparator<? super T>) comparator;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        if ((fromElement == null) || (toElement == null)){
            throw new NullPointerException("FromElement or toElement is null");
        }
        MySortedSet<T> subset = new MySortedSet<T>( comparator);
        int k = 0;
        int indexFromElement = 0;
        int indexToElement = 0;
        for(T el: data){
            if (fromElement.equals(el)){
                indexFromElement = k;
            }
            if (toElement.equals(el)){
                indexToElement = k;
            }
            k++;
        }
        for (int i = indexFromElement; i < indexToElement; i++) {
            subset.add(data[i]);
        }
        return subset;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        if (toElement == null){
            throw new NullPointerException("ToElement is null");
        }
        MySortedSet<T> headSet = new MySortedSet<T>(comparator);
        int k = 0;
        int indexToElement = 0;
        for(T el: data){
            if (toElement.equals(el)){
                indexToElement = k;
            }
            k++;
        }
        for (int i = 0; i < indexToElement; i++) {
            headSet.add(data[i]);
        }
        return headSet;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        if (fromElement == null){
            throw new NullPointerException("FromElement is null");
        }
        MySortedSet<T> tailSet = new MySortedSet<T>(comparator);
        int k = 0;
        int indexFromElement = 0;
        for(T el: data){
            if (fromElement.equals(el)){
                indexFromElement = k;
            }
            k++;
        }
        for (int i = indexFromElement; i < data.length; i++) {
            tailSet.add(data[i]);
        }
        return tailSet;
    }

    @Override
    public T first() {
        if (isEmpty()){
            throw new NoSuchElementException("Set is empty");
        }
        else{
            return data[0];
        }
    }

    @Override
    public T last() {
        if (isEmpty()){
            throw new NoSuchElementException("Set is empty");
        }
        else{
            return data[size];
        }
    }

    public void print() {
        System.out.println("My Sorted Set: ");
        for (int i = 0; i < size; i++) {
            System.out.print("" + data[i] + ",");
        }
    }
}