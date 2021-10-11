import java.util.Iterator;

public class CollectionIterator <T> implements Iterator<T> {
    private int current;
    private T[] data;

    public CollectionIterator(T[] data) {
        this.data = data;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current < data.length;
    }

    @Override
    public T next() {
        T value = data[current];
        current++;
        return value;
    }

    @Override
    public void remove() {
        Object[] newData = (T[]) new Object[data.length - 1];
        for (int i = 0; i < current; i++) {
            newData[i] = data[i];
        }
        for (int i = current; i < data.length - 1; i++) {
            newData[i] = data[i + 1];
        }
        current--;
        data = (T[]) newData;
    }
}
