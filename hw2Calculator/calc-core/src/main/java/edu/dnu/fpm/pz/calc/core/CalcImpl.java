package edu.dnu.fpm.pz.calc.core;

import edu.dnu.fpm.pz.calc.interfaces.Calc;

/**
 * This is implementation of Calc

 */
public class CalcImpl implements Calc
{
    public double getSum(double firstArg, double secondArg) {
        return firstArg + secondArg;
    }

    public double getSubstraction(double firstArg, double secondArg) {
        return firstArg - secondArg;
    }

    public double getMultiplication(double firstArg, double secondArg) {
        return firstArg * secondArg;
    }

    public double getDivision(double firstArg, double secondArg) {
        double division = 0;
        try {
            division = firstArg / secondArg;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
            division = 0;
        }
        return division;
    }
}
