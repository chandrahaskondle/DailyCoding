package com.kondc.java;

// 2 threads prints odd, even elements of array synchronously.
// used object level locking to achieve this.

class RunnableService3 implements Runnable {
    int index = 0;
    int arr[] = {2,4,6,8,10,12,14,16,18,20};
    @Override
    public void run() {
        display();
    }
    public void display() {
        try{
            synchronized (this) {
                while(this.index < 10){
                    if(index%2==0 && Thread.currentThread().getName() == "Thread0") {
                        System.out.println("This is thread-0. Printing Array value: "+this.arr[index++]);
                        this.notify();
                    } else if(index%2==1 && Thread.currentThread().getName() == "Thread1"){
                        System.out.println("This is thread-1. Printing Array value: "+this.arr[index++]);
                        this.notify();
                    } else if(index%2==1 && Thread.currentThread().getName() == "Thread0") {
                        this.wait();
                    } else {
                        this.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error occurred: "+e.toString());
        }
    }
}

public class LearnThread3 {
    public static void main(String[] args) {
        RunnableService3 r1 = new RunnableService3();
        Thread t1 = new Thread(r1);
        t1.setName("Thread0");
        Thread t2 = new Thread(r1);
        t2.setName("Thread1");
        t1.start();
        t2.start();
    }
}
