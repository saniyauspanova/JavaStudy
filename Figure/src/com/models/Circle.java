package com.models;

public class Circle extends Figure {
    public double radius;

    public Circle (double radius) {
        this.type = FigureType.Circle;
        this.radius = radius;
    }

    @Override
    public double perimetr() {
        var result = 2 * Math.PI * radius;
        return result;
    };
    @Override
    public double area() {
        var result = Math.PI * Math.pow(radius, 2);
        return result;
    }
}
