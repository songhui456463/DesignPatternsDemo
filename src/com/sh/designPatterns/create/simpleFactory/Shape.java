package com.sh.designPatterns.create.simpleFactory;

/**
 * @author: songhui
 * @create: 2021-08-18 17:18
 */
public interface Shape {

    void draw();

    void erase();
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("----draw---Triangle-------");
    }

    @Override
    public void erase() {
        System.out.println("----erase---Triangle-------");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("----draw---Square-------");
    }

    @Override
    public void erase() {
        System.out.println("----erase---Square-------");
    }
}

class Circular implements Shape{
    @Override
    public void draw() {
        System.out.println("----draw---Circular-------");
    }

    @Override
    public void erase() {
        System.out.println("----erase---Circular-------");
    }
}

class ShapeFactory{

    public static Shape createShape(String type){
        Shape shape = null;
        if (type.equalsIgnoreCase("Triangle")) {
            shape = new Triangle();
        }
        else if (type.equalsIgnoreCase("Circular")) {
            shape = new Circular();
        }else if(type.equalsIgnoreCase("Square")){
            shape = new Square();
        }
        return shape;
    }
}

class Client3{
    public static void main(String[] args) {
        Shape shape = null;
        shape = ShapeFactory.createShape("Circular");
        shape.draw();
        shape.erase();
    }
}