package ru.kpfu.itis.homework.iterators;

public class T {
    private int par1;
    private String par2;

    public T(int par1, String par2) {
        this.par1 = par1;
        this.par2 = par2;
    }

    @Override
    public String toString() {
        return "T { " +
                "par1  =" + par1 +
                ", par2='" + par2 + '\'' +
                '}';
    }
}
