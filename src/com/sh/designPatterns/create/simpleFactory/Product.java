package com.sh.designPatterns.create.simpleFactory;

/**
 * 定义一个工厂类，它可以根据参数(本实例中type)的不同返回不同类的实例，
 * 被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是静态(static)方法，
 * 因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式
 * @author: songhui
 * @create: 2021-08-18 15:23
 */
// 公共父类
public abstract class Product {

    //所有产品类的公共业务方法
    public void methodSame() {
        //公共方法的实现
        System.out.println("------公共方法----");
    }

    //声明抽象业务方法
    public abstract void methodDiff();

}

// 具体子类
class ConcreteProductA extends Product{
    @Override
    public void methodDiff() {
        System.out.println("-----ConcreteProductA----methodDiff----");
    }
}

// 具体子类
class ConcreteProductB extends Product{
    @Override
    public void methodDiff() {
        System.out.println("-----ConcreteProductB----methodDiff----");
    }
}

// 简单工厂
class Factory{

    public static Product getProduct(String type){
        Product product = null;
        if (type.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
            //初始化设置product
        }
        else if (type.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
            //初始化设置product
        }
        return product;
    }
}

class Client{
    public static void main(String args[]) {
        Product product;
        product = Factory.getProduct("A"); //通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();
    }

}