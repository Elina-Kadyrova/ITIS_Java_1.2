package ru.kpfu.itis.homework.generics;

public class UnitedBooksContainer <PaperBook, PDFBook> {
    PaperBook object1;
    PDFBook object2;

    public UnitedBooksContainer(PaperBook one, PDFBook two) {
        this.object1 = one;
        this.object2 = two;
    }

    public PaperBook getObject1() {
        return object1;
    }

    public PDFBook getObject2() {
        return object2;
    }

}
