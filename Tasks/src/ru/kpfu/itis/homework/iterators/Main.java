package ru.kpfu.itis.homework.iterators;

public class Main {
    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = 25;
        a[1] = 546;
        a[2] = 38;
        a[3] = 3;
        a[4] = 89;
        RevIntArrIterator it = new RevIntArrIterator(a);
        while (it.hasNext()) {
           System.out.println(it.next());
        }

        System.out.println();
        T[] b = new T[3];
        T t1 = new T(23, "tduvjg");
        T t2 = new T(289, "jngl");
        T t3 = new T(3, "fekirobg");
        b[0] = t1;
        b[1] = t2;
        b[2] = t3;
        GenericIterator i = new GenericIterator(b);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println();
        RandomIterator ite = new RandomIterator(a);
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

        System.out.println();
        OddNumIterator iter = new OddNumIterator(a);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
