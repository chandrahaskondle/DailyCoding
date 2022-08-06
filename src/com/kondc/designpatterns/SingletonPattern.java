package com.kondc.designpatterns;

import java.time.LocalDateTime;

/**
 * To create a singleton class
 * - make constructor private
 * - create a static method which returns the single instance created.
 */


// this is eager initialization
class SingletonEagerInit {
    private static SingletonEagerInit sInstance = new SingletonEagerInit();

    private SingletonEagerInit() {
    }

    ;

    public static SingletonEagerInit getInstance() {
        return sInstance;
    }
}

// this is lazy initialization, object is created when needed
class SingletonLazyInit {
    // TODO: Lazy loading
    private static SingletonLazyInit sInstance;

    private SingletonLazyInit() {
    }

    public static SingletonLazyInit getInstance() {
        if (sInstance == null) {
            sInstance = new SingletonLazyInit();
        }
        return sInstance;
    }

}

// this is thread safe method initialization
// All threads have to wait until a single thread completes the method execution. (this is slow)
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod sInstance;

    private SingletonSynchronizedMethod() {
    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (sInstance == null) {
            sInstance = new SingletonSynchronizedMethod();
        }
        return sInstance;
    }
}

// this is thread-safe block initialization
// In this init all threads doesn't wait like in previous ThreadSafeMethod init. (faster than previous init)
class SingletonSynchronizedBlock {
    private static SingletonSynchronizedBlock sInstance;

    private SingletonSynchronizedBlock() {
    }

    public static SingletonSynchronizedBlock getInstance() {
        if (sInstance == null) {
            synchronized (SingletonSynchronizedBlock.class) {
                if (sInstance == null) {
                    sInstance = new SingletonSynchronizedBlock();
                }
            }
        }
        return sInstance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        SingletonEagerInit s1 = SingletonEagerInit.getInstance();
        SingletonEagerInit s2 = SingletonEagerInit.getInstance();
        System.out.println(s1.equals(s2));

        SingletonLazyInit s3 = SingletonLazyInit.getInstance();
        SingletonLazyInit s4 = SingletonLazyInit.getInstance();
        System.out.println(s3.equals(s4));

        SingletonSynchronizedMethod s5 = SingletonSynchronizedMethod.getInstance();
        SingletonSynchronizedMethod s6 = SingletonSynchronizedMethod.getInstance();
        System.out.println(s5.equals(s6));

        SingletonSynchronizedBlock s7 = SingletonSynchronizedBlock.getInstance();
        SingletonSynchronizedBlock s8 = SingletonSynchronizedBlock.getInstance();
        System.out.println(s7.equals(s8));
    }
}