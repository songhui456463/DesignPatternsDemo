package com.sh.designPatterns.create.simpleFactory;

/**
 * @author: songhui
 * @create: 2021-08-18 15:35
 */
//抽象图表接口：抽象产品类
public interface Chart {

    void display();
}

//柱状图类：具体产品类
class HistogramChart implements Chart{

    public HistogramChart(){
        System.out.println("创建柱状图！");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}
//饼状图类：具体产品类
class PieChart implements Chart{

    public PieChart(){
        System.out.println("创建饼状图！");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图！");
    }
}

//折线图类：具体产品类
class LineChart implements Chart{

    public LineChart(){
        System.out.println("创建折线图！");
    }

    @Override
    public void display() {
        System.out.println("显示折线图！");
    }
}


// 创建具体产品，并初始化产品参数有工厂完成
class ChartFactory {

    public static Chart getChart(String type)  {
        Chart chart= null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        }
        else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        }
        else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("初始化设置折线图！");
        }else{
            throw new RuntimeException("传入参数出错");
        }
        return chart;
    }
}

class Client1{
    public static void main(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram"); //通过静态工厂方法创建产品
        chart.display();
    }
}