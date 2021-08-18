package com.sh.designPatterns.create.singleton;

/**
 * 1.构造函数用private修饰->禁止类的外部直接使用new来创建对象
 * 2.定义一个静态的本类类型的私有成员变量->私有变量禁止类的外部直接使用；
 * static修饰->为了将数据存储在全局作用区 使之全局可用
 * 3.增加一个公有静态方法，在方法里提供步骤2中定义的成员变量（
 * 判断是否为空，为空则使用new创建；不为空直接返回）
 * public->保证外部可访问；static->外部可通过类名直接访问（公有静态方法属于类本身，可直接通过类名访问
 * 4.getInstance为静态方法，只能访问静态变量
 * @author: songhui
 * @create: 2021-08-18 19:23
 */
import java.util.*;

//负载均衡器LoadBalancer：单例类，真实环境下该类将非常复杂，包括大量初始化的工作和业务方法，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
public class LoadBalancer {
    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    private List<String> serverList = null;

    //私有构造函数
    private LoadBalancer() {
        serverList = new ArrayList();
    }

    //公有静态成员方法，返回唯一实例
    public static LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        // 该值介于[0,n)的区间
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }
}


class Client {
    public static void main(String args[]) {
        /*当第一次调用getLoadBalancer()方法创建并启动负载均衡器时，
        instance对象为null值，因此系统将执行代码instance= new LoadBalancer()，
        在此过程中，由于要对LoadBalancer进行大量初始化工作，
        需要一段时间来创建LoadBalancer对象。而在此时，如果再一次调用getLoadBalancer()方法
        （通常发生在多线程环境中），由于instance尚未创建成功，
        仍为null值，判断条件(instance== null)为真值，因此代码instance= new LoadBalancer()
    将再次执行，导致最终创建了多个instance对象，这违背了单例模式的初衷，也导致系统运行发生错误*/

        // 也就是说懒汉式天生线程不安全
        //创建四个LoadBalancer对象
        LoadBalancer balancer1,balancer2,balancer3,balancer4;
        balancer1 = LoadBalancer.getLoadBalancer();
        balancer2 = LoadBalancer.getLoadBalancer();
        balancer3 = LoadBalancer.getLoadBalancer();
        balancer4 = LoadBalancer.getLoadBalancer();

        //判断服务器负载均衡器是否相同
        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }

        //增加服务器
        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");
        balancer1.addServer("Server 4");

        //模拟客户端请求的分发
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器： " + server);
        }
    }
}