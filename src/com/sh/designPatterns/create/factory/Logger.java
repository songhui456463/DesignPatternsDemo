package com.sh.designPatterns.create.factory;

/**
 * 相比于简单工厂，工厂方法对工厂进行了抽象
 * @author: songhui
 * @create: 2021-08-18 16:26
 */
// 抽象产品
public interface Logger {

    void write();
}

// 具体产品
class FileLogger implements Logger{
    @Override
    public void write() {
        System.out.println("文件日志记录。");
    }
}
// 具体产品
class DatabaseLogger implements Logger{
    @Override
    public void write() {
        System.out.println("数据库日志记录。");
    }
}
// 抽象工厂
interface LoggerFactory {
    Logger createLogger();
}

// 具体工厂
class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码省略
        return logger;
    }
}
// 具体工厂
class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }
}

class Client{
    public static void main(String[] args) {
        LoggerFactory loggerFactory=new FileLoggerFactory();
        Logger logger=null;
        logger = loggerFactory.createLogger();
        logger.write();
    }
}