package com.company;


import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.models.*;

public class Main {

    public static void main(String[] args) {
        Predicate<Double> isNotPositive = x -> x < 0;

        Consumer<Figure> figureInfo = x-> System.out.printf("Тип фигуры: %s \nПериметр: %f \nПлощадь: %f ", x.type.getNameRus(), x.perimetr(),  x.area());


        Supplier<Double> inputSide = ()-> {
            Scanner in = new Scanner(System.in);
            double side = 0.0;

            while (true) {
                try {
                    side = Double.parseDouble(in.nextLine());
                    while(isNotPositive.test(side))
                    {
                        System.out.println("Введите корректную длину:");
                        side = Double.parseDouble(in.nextLine());
                    }
                    break;
                }
                catch (Exception ex) {
                    System.out.println("Введите корректную длину, число:");
                    continue;
                }
            }

            return side;
        };

        Supplier<Integer> inputType = ()-> {
            Scanner in = new Scanner(System.in);
            System.out.println("Выберите фигуру:\n1.Квадрат \n2.Прямоугольник \n3.Треугольник \n4.Окружность");
            int type = 0;

            while (true) {
                try {
                    type = Integer.parseInt(in.nextLine());
                    while(type <= 0 || type > 4)
                    {
                        System.out.println("Введите корректный тип:\n1.Квадрат \n2.Прямоугольник \n3.Треугольник \n4.Окружность");
                        type = Integer.parseInt(in.nextLine());
                    }
                    break;
                }
                catch (NumberFormatException ex) {
                    System.out.println("Введите корректный тип:\n1.Квадрат \n2.Прямоугольник \n3.Треугольник \n4.Окружность");
                    continue;
                }
            }

            return type;
        };

        Scanner in = new Scanner(System.in);

        int figureType = inputType.get();
        Figure figure;
        double side = 0.0;

        switch (figureType) {
            case 1:
                System.out.println("Введите длину стороны квадрата:");
                side = inputSide.get();
                figure = new Square(side);
                break;
            case 2:
                System.out.println("Введите ширину прямоугольника:");
                double width = inputSide.get();
                System.out.println("Введите длину прямоугольника:");
                double heigth = inputSide.get();
                figure = new Restangle(width, heigth);
                break;
            case 3:
                System.out.println("Введите длину первой стороны треугольника:");
                double sideF = inputSide.get();
                System.out.println("Введите длину второй стороны треугольника:");
                double sideS = inputSide.get();
                System.out.println("Введите длину третьей стороны треугольника:");
                double sideT = inputSide.get();
                figure = new Triangle(sideF, sideS, sideT);
                break;
            case 4:
                System.out.println("Введите длину радиуса круга:");
                double radius = inputSide.get();
                figure = new Circle(radius);
                break;
            default:
                System.out.println("Введите длину стороны квадрата (значение по умолчанию):");
                side = inputSide.get();
                figure = new Square(side);
                break;
        }
        figureInfo.accept(figure);
    }
}
