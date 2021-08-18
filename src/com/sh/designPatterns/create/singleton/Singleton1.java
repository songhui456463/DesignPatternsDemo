package com.sh.designPatterns.create.singleton;

/**
 * 枚举方式
 * @author: songhui
 * @create: 2021-08-18 20:16
 */
public enum Singleton1 {

    INSTANCE,INM;

    public void doSomething() {
        System.out.println("doSomething");
    }

}

class Main {

    public static void main(String[] args) {
        Singleton1.INSTANCE.doSomething();
    }

}