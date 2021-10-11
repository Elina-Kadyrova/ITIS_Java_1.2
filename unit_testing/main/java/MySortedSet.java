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
        if (size == 0){
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
        Object[] elements = new Object[size];
        CollectionIterator<T> it = (CollectionIterator<T>) iterator();
        int k = 0;
        while (it.hasNext() && (k < size)) {
            elements[k] = it.next();
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
        T[] elements = (T[]) new Object[a.length];
        for(int i = 0; i < a.length; i++) {
            if (contains(a[i]))  {
                elements[i] = a[i];
                k++;
            }

        }
        T[] newArr = (T[]) new Object[k];
        int j = 0;
        for (T el: elements) {
            if (el != null) {
                newArr[j] = el;
                j++;
            }
        }
        return newArr;
    }

    public boolean remove(Object o) {
        for (int i=0; i < size; i++) {
            if ((o == null && data[i] == null) || data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean remove(int index) {
        if ((index < 0) || (index >= size)){
            return false;
        }
        if (index < (size-1)) {
            if (size - 1 - index >= 0){
                System.arraycopy(data, index + 1, data, index, size - 1 - index);
            }
        }
        size--;
        return true;
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

    private void increase(){
        T[] newData = (T[])new Object[capacity * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = (T[])newData;
        capacity*=2;
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
        Iterator<T> iter = this.iterator();
        int k = 0;
        while (iter.hasNext() && (k < size)) {
            T temp = iter.next();
            if (!c.contains(temp)){
                return false;
            }
            k++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object el: c){
            if(el!= null){
                if(contains(el)){
                    remove(el);
                }
            }
        }
        return true;
    }

    @Override
    public void clear() {
        int k = size;
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
    public MySortedSet<T> subSet(T fromElement, T toElement) {
        if ((fromElement == null) || (toElement == null)){
            throw new NullPointerException("FromElement or toElement is null");
        }
        MySortedSet<T> subset = new MySortedSet<T>(comparator);
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
    public MySortedSet<T> headSet(T toElement) {
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
    public MySortedSet<T> tailSet(T fromElement) {
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
        for (int i = indexFromElement; i < size; i++) {
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
            return data[size - 1];
        }
    }

    public int getCapacity() {
        return capacity;
    }
}

