package designpatterns.creational.factory;

public interface Shape {
    void draw();
}

enum ShapeEnum {
    RECTANGLE, CIRCLE, SQUARE
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle's draw()...");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square's draw()...");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is Rectangle");
    }
}