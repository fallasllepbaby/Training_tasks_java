package Shapes2;

import java.util.ArrayList;

public class Box extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;
    private double volume;



    public boolean add(Shape shape) {
        if (shape.getVolume() <= available) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    public Box(double available) {
        this.available = available;
        this.volume = available;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
