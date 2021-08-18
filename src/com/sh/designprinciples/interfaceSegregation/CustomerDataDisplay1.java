package com.sh.designprinciples.interfaceSegregation;

/**
 * 每一个接口应该承担一种相对独立的角色，不干不该干的事，该干的事都要干
 * 这里的“接口”往往有两种不同的含义：一种是指一个类型所具有的方法特征的集合，
 * 仅仅是一种逻辑上的抽象；另外一种是指某种语言具体的“接口”定义，
 * 有严格的定义和结构，比如Java语言中的interface
 * 接口仅仅提供客户端需要的行为，
 * 客户端不需要的行为则隐藏起来，应当为客户端提供尽可能小的单独的接口，而不要提供大的总接口。
 * @author: songhui
 * @create: 2021-08-17 23:30
 */
public interface CustomerDataDisplay1 {

    void dataRead();

    void transformToXML();

    void createChart();

    void displayChart();

    void createReport();

    void displayReport();
}

class ConcreteClass1 implements CustomerDataDisplay1{

    @Override
    public void dataRead() {

    }

    @Override
    public void transformToXML() {

    }

    @Override
    public void createChart() {

    }

    @Override
    public void displayChart() {

    }

    @Override
    public void createReport() {

    }

    @Override
    public void displayReport() {

    }
}


class client{

    public static void main(String[] args) {
        CustomerDataDisplay1 c1=new ConcreteClass1();
        c1.createChart();
    }
}



