package com.kondc.java;

// similar to previous code, But uses Class level locking to achieve this.
// 2 threads prints odd, even elements of array synchronously.

class ThreadDemo extends Thread {
    static int pointer = 0;
    int[] arr = {2,4,6,8,10,12,14,16,18,20};

    private Object lock;
    ThreadDemo(ThreadDemo lock) {
        this.lock = lock;
    }
    ThreadDemo(){
        super();
    }

    @Override
    public void run() {
        synchronized (lock){
            try{
                while (this.pointer < this.arr.length ){
                    if (this.getName() == "T1") {
                        if(this.pointer % 2 == 1){
                            lock.wait();
                        }
                        else{
                            System.out.println(this.getName() + " " + this.arr[this.pointer]);
                            this.pointer++;
                            lock.notify();
                        }
                    } else {
                        if(this.pointer % 2 == 0){
                            lock.wait();
                        }
                        else{
                            System.out.println(this.getName() + " " + this.arr[this.pointer]);
                            this.pointer++;
                            lock.notify();
                        }
                    }
                }
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

public class LearnThread4 {
    public static void main(String[] args) {
        ThreadDemo lock = new ThreadDemo();
        ThreadDemo t1 = new ThreadDemo(lock);
        ThreadDemo t2 = new ThreadDemo(lock);
        t1.setName("T1");
        t1.start();
        t2.setName("T2");
        t2.start();

        try{
            // main thread waits until 2 threads die. "EOP" will not be printed till both threads die.
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread join failed");
        }

        System.out.println("EOP");
    }
}
