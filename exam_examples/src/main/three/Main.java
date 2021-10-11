package main.three;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 45, -4, 355, -2, 5, -23};
        MyThread th1 = new MyThread(arr1);
        MyThread th2 = new MyThread(arr1);
    }
}

class MyThread implements Runnable{
    int[] numbers;

    public MyThread(int[] numbers) {
        this.numbers = numbers;
        this.run();
    }

    @Override
    public void run() {
        int sum = 0;
            System.out.println(sum);
    }

    public int toSum(int sum, int num){
        if (num > 0){
            sum+=num;
            System.out.println("+");
        }
        return sum;
    }
}