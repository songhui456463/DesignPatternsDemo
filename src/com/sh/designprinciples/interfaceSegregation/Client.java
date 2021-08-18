package com.sh.designprinciples.interfaceSegregation;

/**
 * 由于在接口CustomerDataDisplay中定义了太多方法，
 * 即该接口承担了太多职责，一方面导致该接口的实现类很庞大，
 * 在不同的实现类中都不得不实现接口中定义的所有方法，灵活性较差，
 * 如果出现大量的空方法，将导致系统中产生大量的无用代码，影响代码质量；
 * 另一方面由于客户端针对大接口编程，将在一定程序上破坏程序的封装性，
 * 客户端看到了不应该看到的方法，没有为客户端定制接口。
 * 因此需要将该接口按照接口隔离原则和单一职责原则进行重构，
 * 将其中的一些方法封装在不同的小接口中，确保每一个接口使用起来都较为方便，
 * 并都承担某一单一角色，每个接口中只包含一个客户端（如模块或类）所需的方法即可。
 * @author: songhui
 * @create: 2021-08-18 11:55
 */
public class Client{
    public static void main(String[] args) {
        /*在使用接口隔离原则时，
        我们需要注意控制接口的粒度，接口不能太小，
        如果太小会导致系统中接口泛滥，不利于维护；
        接口也不能太大，太大的接口将违背接口隔离原则，
        灵活性较差，使用起来很不方便。一般而言，
        接口中仅包含为某一类用户定制的方法即可，
        不应该强迫客户依赖于那些它们不用的方法。*/
        DataHandler d1 = new ConcreteClass2();
        d1.dataRead();

        ChartHandler c1 =new ConcreteClass2();
        c1.createChart();
        c1.displayChart();
    }
}


class ConcreteClass2 implements DataHandler,ChartHandler {

    @Override
    public void dataRead() {
        System.out.println("------readData----");
    }

    @Override
    public void createChart() {
        System.out.println("------createChart----");
    }

    @Override
    public void displayChart() {
        System.out.println("------displayChart----");
    }
}

// 如果接口存在实现类不需要的方法，就将接口进行分隔
interface DataHandler{
    void dataRead();
}

interface XMLTransform{
    void transformToXML();
}

interface ChartHandler{
    void createChart();

    void displayChart();
}

interface ReportHandler{
    void createReport();

    void displayReport();
}

