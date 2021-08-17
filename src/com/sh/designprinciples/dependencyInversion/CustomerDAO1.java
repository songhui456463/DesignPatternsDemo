package com.sh.designprinciples.dependencyInversion;

/**
 *   Sunny软件公司开发人员在开发某CRM系统时发现：
 *   该系统经常需要将存储在TXT或Excel文件中的客户信息转存到数据库中
 *   ，因此需要进行数据格式转换。在客户数据操作类中将调用数据格式
 *   转换类的方法实现格式转换和数据库插入操作，
 * @author: songhui
 * @create: 2021-08-17 22:47
 */
public class CustomerDAO1 {

    void addCustomers(){
        TXTDataConvertor1 tConvertor =new TXTDataConvertor1();
        tConvertor.readFile();
    };

    public static void main(String[] args) {
        /*于每次转换数据时数据来源不一定相同，
        因此需要更换数据转换类，
        如有时候需要将TXTDataConvertor改为ExcelDataConvertor，
        此时，需要修改CustomerDAO的源代码，
        而且在引入并使用新的数据转换类时也不得不修改CustomerDAO的源代码，
        系统扩展性较差，违反了开闭原则，现需要对该方案进行重构。*/
        CustomerDAO1 customerDAO1 = new CustomerDAO1();
        customerDAO1.addCustomers();
    }

}

class TXTDataConvertor1{

    void readFile(){
        System.out.println("------TXTDataConvertor1-------");
    }
}

class ExcelDataConvertor1{

    void readFile(){
        System.out.println("------ExcelDataConvertor1-------");
    }
}