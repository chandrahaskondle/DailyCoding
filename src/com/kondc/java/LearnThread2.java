package com.kondc.java;

/*
    Sample code:
    Object level locking => synchronized(this) block, synchronized method
    Class level locking => synchronized(ClassName.class) block, synchronized static method
 */

class RunnableService2 implements Runnable{
    public void display() {
        synchronized(RunnableService2.class){
            try{
                System.out.println(Thread.currentThread().getName()+" runnable Thread Started");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" runnable Thread Ended");
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        display();
    }
}

public class LearnThread2 {
    public static void main(String[] args) {
        // sample code: Object level locking
//        RunnableService2 r1 = new RunnableService2();
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r1);
//
//        t1.start();
//        t2.start();

        // sample code: Class level locking
        RunnableService2 r2 = new RunnableService2();
        RunnableService2 r3 = new RunnableService2();

        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r3);

        t3.start();
        t4.start();
    }
}
