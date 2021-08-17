package com.sh.designprinciples.dependencyInversion;

/**
 * 由于CustomerDAO针对具体数据转换类编程，
 * 因此在增加新的数据转换类或者更换数据转换类时都不得不修改CustomerDAO的源代码。
 * 我们可以通过引入抽象数据转换类解决该问题
 * 闭原则是目标，里氏代换原则是基础，依赖倒转原则是手段
 * @author: songhui
 * @create: 2021-08-17 22:52
 */
public class CustomerDAO2 {

    private Convertor convertor;

    // 构造注入
    public CustomerDAO2(Convertor convertor){
        this.convertor = convertor;
    }

    // set注入
    public void setConvertor(Convertor convertor) {
        this.convertor = convertor;
    }

    void addCustomers(){
        this.convertor.readFile();
    }

    public static void main(String[] args) {
        CustomerDAO2 c2=new CustomerDAO2(new TXTDataConvertor2());
        c2.addCustomers();
    }
}

interface Convertor{

    void readFile();
}

class TXTDataConvertor2 implements Convertor{

    @Override
    public void readFile(){
        System.out.println("------TXTDataConvertor2-------");
    }
}

class ExcelDataConvertor2 implements Convertor{

    @Override
    public void readFile(){
        System.out.println("------ExcelDataConvertor2-------");
    }
}
