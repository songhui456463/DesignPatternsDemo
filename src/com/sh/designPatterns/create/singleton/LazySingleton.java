package com.sh.designPatterns.create.singleton;

/**
 * 在类加载时并不自行实例化，这种技术又称为延迟加载(Lazy Load)技术
 * @author: songhui
 * @create: 2021-08-18 19:41
 */
public class LazySingleton {

    // 双重检查锁定(Double-Check Locking)，被volatile修饰的成员变量可以确保多个线程都能够正确处
    private volatile static LazySingleton instance = null;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        // 因为本方法为静态方法，锁方法和锁类的效果是一样的，
        // 但是在锁方法在无论什么时候都要进行线程锁定判断，
        // 而我们需要解决的问题是防止创建多个对象，锁类可以做到，
        // 并且在后续访问已创建对象时少了锁的判断，极大地提高了并发程度和系统性能
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

}
