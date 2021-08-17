package com.sh.designprinciples.openClosed;

/**
 * 在本实例中，由于在ChartDisplay类的display()方法中针对每一个图表类编程，
 * 因此增加新的图表类不得不修改源代码。
 * 可以通过抽象化的方式对系统进行重构，使之增加新的图表类时无须修改源代码，满足开闭原则。具体做法如下：
 * (1) 增加一个抽象图表类AbstractChart，将各种具体图表类作为其子类；
 * (2)  ChartDisplay类针对抽象图表类进行编程，由客户端来决定使用哪种具体图表。
 * @author: songhui
 * @create: 2021-08-17 21:48
 */
public class ChartDisplay2 {

    private AbstractChart abstractChart;

    void setAbstractChart(AbstractChart abstractChart){
        this.abstractChart = abstractChart;
    }

    void display(){
        this.abstractChart.display();
    }

    public static void main(String[] args) {
        ChartDisplay2 chartDisplay2=new ChartDisplay2();
        // 利用向上转型
        chartDisplay2.setAbstractChart(new PieChart2());
        chartDisplay2.display();

        chartDisplay2.setAbstractChart(new BarChart2());
        chartDisplay2.display();

    }
}

abstract class AbstractChart{

    abstract void display();

}

class PieChart2 extends AbstractChart{

    @Override
    void display(){
        System.out.println("----PieChart----");
    }
}

class BarChart2 extends AbstractChart{

    @Override
    void display(){
        System.out.println("----BarChart----");
    }
}
