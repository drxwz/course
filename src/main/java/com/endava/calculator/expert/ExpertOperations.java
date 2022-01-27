package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {

    double pow(int base, int exponent);

    double root(int a);

    long fact(int n);

    long factRec(int n);

    double calculate(String s);

}
