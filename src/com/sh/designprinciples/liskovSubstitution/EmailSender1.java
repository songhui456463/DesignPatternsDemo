package com.sh.designprinciples.liskovSubstitution;

/**
 *    在Sunny软件公司开发的CRM系统中，
 *    客户(Customer)可以分为VIP客户(VIPCustomer)和普通客户(CommonCustomer)两类，
 *    系统需要提供一个发送Email的功能
 *    在对系统进行进一步分析后发现，无论是普通客户还是VIP客户，
 *    发送邮件的过程都是相同的，也就是说两个send()方法中的代码重复，而且在本系统中还将增加新类型的客户。
 *    为了让系统具有更好的扩展性，同时减少代码重复，使用里氏代换原则对其进行重构。
 * @author: songhui
 * @create: 2021-08-17 22:18
 */
public class EmailSender1 {

    void send(CommonCustomer1 commonCustomer){
        System.out.println(commonCustomer.toString());
    }

    void send(VIPCustomer1 vipCustomer){
        System.out.println(vipCustomer.toString());
    }

    public static void main(String[] args) {
        EmailSender1 emailSender1=new EmailSender1();

        CommonCustomer1 c1=new CommonCustomer1();
        c1.setEmail("1677279299@qq.com");
        c1.setName("sh");

        VIPCustomer1 v1 = new VIPCustomer1();
        v1.setEmail("1736977319@qq.com");
        v1.setName("su");

        emailSender1.send(c1);
        emailSender1.send(v1);
    }
}


class CommonCustomer1{

    private String name;

    private String email;

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

    @Override
    public String toString() {
        return "CommonCustomer1{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class VIPCustomer1{

    private String name;

    private String email;

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

    @Override
    public String toString() {
        return "VIPCustomer1{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

