package com.sh.designprinciples.liskovSubstitution;

/**
*    里氏代换原则是实现开闭原则的重要方式之一，
 *   由于使用基类对象的地方都可以使用子类对象，
 *   因此在程序中尽量使用基类类型来对对象进行定义，
 *   而在运行时再确定其子类类型，用子类对象来替换父类对象。
 * @author: songhui
 * @create: 2021-08-17 22:25
 */
public class EmailSender2 {

    void send(Customer customer){
        System.out.println(customer.toString());
    }

    public static void main(String[] args) {
        /*里氏代换原则是实现开闭原则的重要方式之一。
        在本实例中，在传递参数时使用基类对象，
        除此以外，在定义成员变量、定义局部变量、
        确定方法返回类型时都可使用里氏代换原则。
        针对基类编程，在程序运行时再确定具体子类。*/
        Customer c1=new CommonCustomer2();
        c1.setEmail("1677279299@qq.com");
        c1.setName("sh");

        Customer c2 = new VIPCustomer2();
        c2.setEmail("1736977319@qq.com");
        c2.setName("su");

        EmailSender2 e2=new EmailSender2();
        e2.send(c1);
        e2.send(c2);

    }
}



class Customer{

   protected String name;

   protected String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}



class CommonCustomer2 extends Customer{


    @Override
    public String toString() {
        return "CommonCustomer2{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


class VIPCustomer2 extends Customer{

    @Override
    public String toString() {
        return "VIPCustomer2{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

