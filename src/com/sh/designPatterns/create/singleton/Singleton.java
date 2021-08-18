package com.sh.designPatterns.create.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；
 * 懒汉式单例类线程安全控制烦琐，而且性能受影响。
 * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载，
 * 同时静态内部类的加载不需要依附外部类，
 * 在使用时才加载，不过在加载静态内部类的过程中也会加载外部类
 * (延迟加载由静态内部类的加载机制实现)
 * @author: songhui
 * @create: 2021-08-18 19:57
 */
public class Singleton implements Serializable {

    private Singleton(){}

    private static class HolderClass{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return HolderClass.instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        // 通过结果看，这两个实例不是同一个，这就违背了单例模式的原则了。(不加Serializable)
        // 利用反射可以破坏静态内部类的单例原则
        Singleton singleton = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);

        /*<dependency>
             <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
             <version>3.8.1</version>
        </dependency>*/
        // Singleton instance = Singleton.getInstance();
        // byte[] serialize = SerializationUtils.serialize(instance);
        // Singleton newInstance = SerializationUtils.deserialize(serialize);
        // System.out.println(instance == newInstance);
    }

}
