package com.bridgelabz.mathoperationsapp;

@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
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
        System.out.println("Addition is : " +addition.calculate(6, 3));
        System.out.println("Subtraction is : " +subtract.calculate(8, 2));
        System.out.println("Multiplication is : " +multiply.calculate(5, 4));
        System.out.println("Division is : " +divide.calculate(4, 2));

    }
}
