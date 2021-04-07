package edu.dnu.fpm.pz.calc.console;


import edu.dnu.fpm.pz.calc.core.CalcImpl;
import edu.dnu.fpm.pz.calc.interfaces.Calc;

/**
 * My Demo
 *
 */
public class App
{
    //consts for errors
    public static final String NOT_ENOUGHT = "Not enought parameters!";
    public static final String FIRST_INVALID = "Invalid first argument!";
    public static final String SECOND_INVALID = "Invalid second argument!";
    public static final String OPERATOR_INVALID = "Invalid operator!";

    // consts for operation
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    //consts for result output
    public static final String NUM1 = "number1= ";
    public static final String NUM2 = " number2= ";
    public static final String OPERATOR = " operator= ";
    public static final String RESULT = " result= ";

    public static final int ARGS_COUNT = 3;

    public static void main( String[] args )
    {
        if (args.length < ARGS_COUNT)  {
            System.err.println(NOT_ENOUGHT);
            return;
        }

        Calc calculator = new CalcImpl();
        double firstArg;
        try{
            firstArg= Double.parseDouble(args[0]);
        } catch (NullPointerException e) {
            System.err.println(FIRST_INVALID);
            return;
        }

        double secondArg;
        try{
            secondArg = Double.parseDouble(args[1]);
        } catch (NullPointerException e) {
            System.err.println(SECOND_INVALID);
            return;
        }

        double result = 0;
        switch (args[2]) {
            case PLUS:
                result = calculator .getSum(firstArg, secondArg);
                break;
            case MINUS:
                result = calculator .getSubstraction(firstArg, secondArg);
                break;
            case MULTIPLY:
                result = calculator .getMultiplication(firstArg, secondArg);
                break;
            case DIVIDE:
                result = calculator .getDivision(firstArg, secondArg);
                break;
            default: {
                System.err.println(OPERATOR_INVALID);
                return;
            }
        }

        System.out.println(NUM1 + firstArg + NUM2 + secondArg
                + OPERATOR + args[2]+ RESULT + result);
    }
}
