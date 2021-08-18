package com.sh.designPatterns.create.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式天生线程安全,处理反射
 * @author: songhui
 * @create: 2021-08-18 19:37
 */
public class EagerSingleton {

    private static final EagerSingleton instance=new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }

}

class Client1{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EagerSingleton singleton = EagerSingleton.getInstance();
        Constructor<EagerSingleton> constructor = EagerSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EagerSingleton newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);
    }
}