package com.sh.designPatterns.create.factory;

/**
 * 通过将业务方法的调用移入工厂类，可以直接使用工厂对象来调用产品对象的业务方法，客户端无须直接使用工厂方法
 * @author: songhui
 * @create: 2021-08-18 17:33
 */
public interface Image {

    void readImage();
}

class GIFImage implements Image{
    @Override
    public void readImage() {
        System.out.println("-----GIFImage---------");
    }
}

class JPGImage implements Image{
    @Override
    public void readImage() {
        System.out.println("-----JPGImage---------");
    }
}

interface ImageFactory{

    Image getImage();
}

class GIFImageFactory implements ImageFactory{
    @Override
    public Image getImage() {
        return new GIFImage();
    }
}

class JPGImageFactory implements ImageFactory{
    @Override
    public Image getImage() {
        return new JPGImage();
    }
}

class Client2{
    public static void main(String[] args) {
        Image image = null;
        ImageFactory imageFactory = new GIFImageFactory();
        image = imageFactory.getImage();
        image.readImage();
    }
}