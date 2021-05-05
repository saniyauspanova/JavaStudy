package com.models;

public enum FigureType {
    Triangle("Треугольник"), Square("Квадрат"), Circle("Окружность"), Restangle("Прямоугольник");
    private String name;

    FigureType(String name) {
        this.name = name;
    }

    public String getNameRus() {
        return name;
    }
}
