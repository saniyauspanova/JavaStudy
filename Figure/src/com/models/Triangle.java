package com.models;

public class Triangle extends Figure {
    public double firstSide;
    public double secondSide;
    public double thirdSide;
    public Triangle (double firstSide, double secondSide, double thirdSide ) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }
    @Override
    public double perimetr() {
        var result = firstSide + secondSide + thirdSide;
        return result;
    };
    @Override
    public double area() {
        var halfPerimetr = firstSide + secondSide + thirdSide;
        var result = Math.sqrt(halfPerimetr* (halfPerimetr - firstSide) * (halfPerimetr - secondSide) *(halfPerimetr - thirdSide));
        return result;
    }
    @Override
    public String getFigureType() {
        return "Треугольник";
    }
}
