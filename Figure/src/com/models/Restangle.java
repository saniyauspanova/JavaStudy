package com.models;

public class Restangle extends Figure {
    public double firstSide;
    public double secondSide;

    public Restangle (double firstSide, double secondSide) {
        this.type = FigureType.Restangle;
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double perimetr() {
        var result = 2 * (firstSide + secondSide);
        return result;
    };
    @Override
    public double area() {
        var result = firstSide * secondSide;
        return result;
    }
}
