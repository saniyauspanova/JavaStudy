package com.models;

public class Square extends Figure {
    public double firstSide;

    public Square (double firstSide) {
        this.firstSide = firstSide;
    }

    @Override
    public double perimetr() {
        var result = 4 * firstSide;
        return result;
    };
    @Override
    public double area() {
        var result = Math.pow(firstSide, 2);
        return result;
    }
    @Override
    public String getFigureType() {
        return "Квадрат";
    }
}