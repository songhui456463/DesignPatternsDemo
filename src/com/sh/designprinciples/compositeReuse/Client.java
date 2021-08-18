package com.sh.designprinciples.compositeReuse;

/**
 * 在本实例中我们可以使用关联复用来取代继承复用
 * @author: songhui
 * @create: 2021-08-18 12:38
 */
public class Client {

    public static void main(String[] args) {
        /*CustomerDAO和DBUtil之间的关系由继承关系变为关联关系，
        采用依赖注入的方式将DBUtil对象注入到CustomerDAO中，
        可以使用构造注入，也可以使用Setter注入。如果需要对DBUtil的功能进行扩展，
        可以通过其子类来实现，如通过子类OracleDBUtil来连接Oracle数据库。
        由于CustomerDAO针对DBUtil编程，根据里氏代换原则，DBUtil子类的对象可以覆盖DBUtil对象，
        只需在CustomerDAO中注入子类对象即可使用子类所扩展的方法。
        例如在CustomerDAO中注入OracleDBUtil对象，即可实现Oracle数据库连接，
        原有代码无须进行修改，而且还可以很灵活地增加新的数据库连接方式。*/
        CustomerDAO c1 =new CustomerDAO(new OracleDBUTil());
        c1.addCustomer();
    }

}

class DBUtil{

    public void getConnection(){
        System.out.println("mysql获取连接");
    }

}

class OracleDBUTil extends DBUtil{

    @Override
    public void getConnection() {
        System.out.println("oracle获取连接");
    }
}

class CustomerDAO{

    public DBUtil dbUtil;

    public CustomerDAO(DBUtil dbUtil){
        this.dbUtil = dbUtil;
    }

    void addCustomer(){
        this.dbUtil.getConnection();
    }

}



