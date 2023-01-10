/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_11;

/**
 *
 * @author Abennaya
 */
import java.text.DecimalFormat;

abstract class Shape {
    abstract double getArea();
    abstract String getName();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getName() {
        return "Circle";
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    String getName() {
        return "Square";
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        Circle circle = new Circle(5);
        System.out.println("Area of " + circle.getName() + ": " + df.format(circle.getArea()));

        Square square = new Square(5);
        System.out.println("Area of " + square.getName() + ": " + df.format(square.getArea()));
    }
}

