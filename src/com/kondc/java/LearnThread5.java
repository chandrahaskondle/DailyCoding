package com.kondc.java;

//  intrinsic locks, reentrant locks => ???

class PrintNumbersRunnable implements Runnable {
    static int i = 0;
    private Object lock;

    public PrintNumbersRunnable(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        printArray();
    }

    private void printArray() {
        synchronized (lock) {
            while(i<10) {
                try{
                    if (Thread.currentThread().getName() == "EvenThread") {
                        if (i % 2 == 0) {
                            System.out.println("EvenThread: " + i++);
                            lock.notifyAll();
                        } else
                            lock.wait();
                    } else if (Thread.currentThread().getName() == "OddThread") {
                        if (i % 2 == 1) {
                            System.out.println("OddThread: " + i++);
                            lock.notifyAll();
                        } else
                            lock.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occurred: " + e.toString());
                }
            }
        }
    }
}

public class LearnThread5 {
    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new PrintNumbersRunnable(lock);
        Runnable r2 = new PrintNumbersRunnable(lock);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setName("EvenThread");
        t2.setName("OddThread");
        t1.start();
        t2.start();
    }
}
