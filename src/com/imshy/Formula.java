package com.imshy;

import java.io.BufferedReader;
import java.util.Arrays;

public class Formula {

    int solve(String equation) {
        Tools tools = new Tools();
        String eq = tools.stripWhitespace(equation);
        // parenthesis
        int indexOfOpening;
        if ((indexOfOpening = eq.indexOf('(')) != -1) {
            int indexOfClosing = tools.findClosingParentheses(eq, indexOfOpening);
            // removes the first parentheses and replaces it with the answer of what's inside
            // recursion with the solved parentheses
            return solve(
                    eq.substring(0, indexOfOpening)
                    + solve(eq.substring(indexOfOpening + 1, indexOfClosing))
                    + eq.substring(indexOfClosing+1)
            );
        }
        // no parentheses shall exist past this point
        int indexOfNextOperator = indexNextOperator(eq);
        // operator not found, assuming the input is solely a number
        if (indexOfNextOperator == -1) return Integer.parseInt(eq);
        String[] vals = eq.split("[+\\-*/]");
        String[] opers = eq.split("[1234567890]");
        if (vals.length > 2) {

        } else if (vals.length == 2) {
            return miniCalc(eq);
        }
        return 01;
    }
    // splits stringed equation into array of numbers and operators
    private String[] splitter(String equation)
    {
        String[] vals = equation.split("[+\\-*/]");
        String[] opers = equation.split("[1234567890]");
        String[] total = new String[vals.length + opers.length];
        for(int i = 0; i < vals.length; i++)
        {
            total[i] = vals[]
        }
    }
    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    // returns index
    // returns the index of the operator that will be used next
    // according to BEDMAS
    /*NOTE does not take into account brackets or parentheses*/
    private int indexNextOperator(String formula) {
        //EXPONENT
        int power;
        if ((power = formula.indexOf("^")) != -1) {
            return power;
        }
        // Multiplication and division
        int multiplication = formula.indexOf("*");
        int division = formula.indexOf("/");
        int temp;
        if ((temp = bestIndex(multiplication, division)) != -1) return temp;
        // addition and subtraction
        int addition = formula.indexOf("+");
        int subtraction = formula.indexOf("-");
        // can result in returning -1
        // -1 is due to the inputted formula not including an operator
        return bestIndex(addition, subtraction);
    }

    private int bestIndex(int one, int two) {
        int lowest = Math.min(one, two);
        int highest = Math.max(one, two);
        return lowest != -1 ? lowest : highest;
    }

    // does a single operation
    // ex: 5*23 or 8/4
    private int miniCalc(String miniEquation) {
        String[] vals = miniEquation.split("[+\\-*/]");
        int num1 = Integer.parseInt(vals[0]);
        int num2 = Integer.parseInt(vals[1]);
        char oper = miniEquation.split(vals[0])[1].charAt(0);
        return switch (oper) {
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '^' -> (int) Math.pow(num1, num2);
            default -> throw new IllegalStateException("Unexpected operator: " + oper);
        };
    }
}

class CharIndex {
    public CharIndex(char c, int index) {
        this.c = c;
        this.index = index;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    char c;
    int index;
}