package com.bridgelabz.mathoperationsapp;

@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
    static void printResult(int a, int b, String function, IMathFunction fobj){
        System.out.println("Result of "+function+" is "+fobj.calculate(a, b));
    }
}

public class MathOperationsApp {

    public static void main (String [] args){
        //use of method reference to execute addition
        IMathFunction addition = Integer::sum;
        //subtraction with lambda function
        IMathFunction subtract = (x, y) -> x - y;
        //multiplication with lambda function
        IMathFunction multiply = (x, y) -> x * y;
        //division with lambda function
        IMathFunction divide = (int x, int y) -> x / y;

        //Executing the simple math operations
        IMathFunction.printResult(6, 3, "Addition", addition);
        IMathFunction.printResult(8, 2, "Subtraction", subtract);
        IMathFunction.printResult(5, 4, "Multiplication", multiply);
        IMathFunction.printResult(4, 2, "Division", divide);

    }
}
