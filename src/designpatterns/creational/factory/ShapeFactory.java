package designpatterns.creational.factory;

public class ShapeFactory {
    public Shape getShape(ShapeEnum shape) {
        switch (shape) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new IllegalStateException("Unexpected value: " + shape);
        }
    }
}
