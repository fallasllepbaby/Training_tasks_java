package Shapes3;

import java.util.ArrayList;

public class Box implements Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double volume;
    private double available;

    public boolean add(Shape shape) {
        if (shape.getVolume() <= available) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    public Box(double volume) {
        this.available = volume;
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
