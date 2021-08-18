package com.sh.designprinciples.compositeReuse;

/**
 * Sunny软件公司开发人员在初期的CRM系统设计中，
 * 考虑到客户数量不多，系统采用MySQL作为数据库，
 * 与数据库操作有关的类如CustomerDAO类等都需要连接数据库，
 * 连接数据库的方法getConnection()封装在DBUtil类中，
 * 由于需要重用DBUtil类的getConnection()方法，
 * 设计人员将CustomerDAO作为DBUtil类的子类
 * @author: songhui
 * @create: 2021-08-18 12:30
 */
public class DBUtil1 {

    public void getConnection(){
        System.out.println("获取数据库连接");
    }

    public static void main(String[] args) {
        CustomerDAO1 customerDAO = new CustomerDAO1();
        customerDAO.addCustomers();
    }
}

class CustomerDAO1 extends DBUtil1{

    void addCustomers(){
        super.getConnection();
    }
}

