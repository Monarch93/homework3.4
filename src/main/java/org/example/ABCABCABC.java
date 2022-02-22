package org.example;

public class ABCABCABC {
    private int currentThreadNumber = 1;
    private int loopsCount = 5;

    public static void main(String[] args) {
        ABCABCABC abcSample = new ABCABCABC();
        Thread thread1 = new Thread(() -> abcSample.method1());
        Thread thread2 = new Thread(() -> abcSample.method2());
        Thread thread3 = new Thread(() -> abcSample.method3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void method1() {
        try {
            synchronized (this) {
                for (int i = 0; i < loopsCount; i++) {
                    while (currentThreadNumber != 1) {
                        wait();
                    }
                    System.out.print("A");
                    currentThreadNumber++;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        try {
            synchronized (this) {
                for (int i = 0; i < loopsCount; i++) {
                    while (currentThreadNumber != 2) {
                        wait();
                    }
                    System.out.print("B");
                    currentThreadNumber++;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method3() {
        try {
            synchronized (this) {
                for (int i = 0; i < loopsCount; i++) {
                    while (currentThreadNumber != 3) {
                        wait();
                    }
                    System.out.print("C");
                    currentThreadNumber = 1;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
