package com.kondc.java;
/*
There are two ways to create a thread. Class either
1) class extends thread class or
2) Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.

thread methods: 1) start 2) sleep 3) wait 4) notify 5) join 6) setName, getName 7) setPriority, getPriority
 */

class ThreadService1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread created by extending Thread Class");
    }
}

class RunnableService1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread created using instance which implemented Runnable Interface");
    }
}

public class LearnThread1 {

    // Lambda expressions supports SAM interface instance creation. Created Runnable instance using Lambda.
    static Thread thread3 = new Thread(()-> {
        System.out.println("Thread created using lambda expression");
    });

    public static void main(String[] args) {
        ThreadService1 thread1 = new ThreadService1();
        thread1.start();    // thread created by extending thread class (also, need to override run method)

        RunnableService1 r1 = new RunnableService1();
        Thread thread2 = new Thread(r1);
        thread2.start();    // thread created by using runnable implemented class instance.

        thread3.start();    // thread created by implementing runnable (
    }
}
