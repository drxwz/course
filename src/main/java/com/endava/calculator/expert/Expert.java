package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations {

    private String[] operators = {"+", "-", "%", "*", "/"};

    public Expert() {
        decimals = 10;
    }

    public Expert(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public double pow(int base, int exponent) {
        double result = 1;
        for (int i = 1; i <= Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent >= 0) {
            return result;
        } else {
            return formatNumber(1 / result);
        }
    }

    @Override
    public double root(int a) {
        return formatNumber(Math.sqrt(a));
    }

    @Override
    public long fact(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public long factRec(int n) {
        // n! = n(n-1)!
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return n * factRec(n - 1);
        } else {
            throw new IllegalArgumentException("You cannot calculate factorial for a negative number.");
        }
    }

    @Override
    public double calculate(String s) {

//        boolean hasOperator = false;
//        for (String o : operators) {
//            if (s.contains(o)) {
//                hasOperator = true;
//            }
//        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            if (s.contains("(")) {
                int startIndex = s.indexOf("(");
                int endIndex = s.indexOf(")");
                String left = s.substring(0, startIndex);
                String right = s.substring(endIndex + 1);
                String center = s.substring((startIndex + 1), endIndex);

                double result = calculate(center);
                return calculate(left + result + right);

            } else {
                for (String o : operators) {
                    int index = s.lastIndexOf(o);
                    if (index == -1) {
                        continue;
                    }

                    String leftSide = s.substring(0, index);
                    if ( index != 0  && (leftSide.trim().charAt(leftSide.trim().length() - 1) == '+' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '-'
                        || leftSide.trim().charAt(leftSide.trim().length() - 1) == '*' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '/')) {
                        continue;
                    }
                    double leftOperand = index == 0 ? 0.0 : calculate(leftSide);
                    double rightOperand = calculate(s.substring(index + 1));
                    switch (o) {
                        case "+":
                            return add(leftOperand, rightOperand);
                        case "-":
                            return subtract(leftOperand, rightOperand);
                        case "*":
                            return multiply(leftOperand, rightOperand);
                        case "/":
                            return divide(leftOperand, rightOperand);
                        case "%":
                            return leftOperand % rightOperand;
                        default:
                            throw new IllegalArgumentException("Invalid operator" + o);
                    }
                }
                throw new RuntimeException("Operator field needs at least one value");

            }
        }

    }
}
