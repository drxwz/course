package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations b = new Basic(1);
        ExpertOperations e = new Expert(3);

        System.out.println("Addition " + b.add(2, 3, 4, 5));
        System.out.println("Subtraction " + b.subtract(2));
        System.out.println("Multiplication " + b.multiply(2, 6));
        System.out.println("Division " + b.divide(10, 3));
        System.out.println("Multiplication " + b.multiply(3.5, 2.3));
        System.out.println("Power " + e.pow(2, -1));
        System.out.println("Root " + e.root(4));
        System.out.println("Fact " + e.fact(3));
        System.out.println("Division " + b.divide(20, 0));
        System.out.println("=============================================");
//        System.out.println(e.calculate("22.5 + 33.35 + 5 "));
//        System.out.println(e.calculate("-3 - 5 * 3"));
//        System.out.println(e.calculate("2 * (-3+2)"));
        System.out.println(e.calculate("2 + (-3-5) * ( -7-5)"));

        System.out.println(e.calculate("(3+2)/5*5-(8/2)"));
//        System.out.println(e.calculate("(2*(-3+7)) + 4 "));  //StringIndexOutOfBoundException





    }
}
