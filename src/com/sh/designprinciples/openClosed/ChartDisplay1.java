package com.sh.designprinciples.openClosed;

/**
 *  Sunny软件公司开发的CRM系统可以显示各种类型的图表
 *  在该代码中，如果需要增加一个新的图表类，如折线图LineChart，
 *  则需要修改ChartDisplay类的display()方法的源代码，
 *  增加新的判断逻辑，违反了开闭原则。
 * @author: songhui
 * @create: 2021-08-17 21:43
 */
public class ChartDisplay1 {

    public static void main(String[] args) {
        ChartDisplay1 chartDisplay1=new ChartDisplay1();
        chartDisplay1.display("pie");
    }


    void display(String type){
        if (type.equals("pie")) {
            PieChart1 chart = new PieChart1();
            chart.display();
        }
        else if (type.equals("bar")) {
            BarChart1 chart = new BarChart1();
            chart.display();
        }
    };
}

class PieChart1{

    void display(){
        System.out.println("----PieChart----");
    }
}

class BarChart1{

    void display(){
        System.out.println("----BarChart----");
    }
}