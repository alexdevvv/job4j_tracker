package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {
    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double differenceAndDiv(double first, double second) {
        return difference(first, second)
                + division(first, second);
    }

    public static double allSumMethods(double first, double second) {
        return sumAndMultiply(first, second) + difference(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат рассчета равен: " + sumAndMultiply(10, 20));
    }

}
