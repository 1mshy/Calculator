package com.imshy;

public class Tools {
    // checks to see if a string has the same amount of opening and closing parenthesis
    boolean hasEqualParanthesis(String equation) {
        int open = 0, closed = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                open++;
            }
            else if  (c == ')') {
                closed++;
            }
        }
        return open==closed;
    }

    boolean hasCorrentParanthesis(String equation) {
        if (!hasEqualParanthesis(equation)) return false;
        // count is the amount of unpaired parentheses
        int count = 1;
        for (int i = equation.indexOf('(')+1; i < equation.length(); i++)
        {
            char c = equation.charAt(i);
            if (c == '(') {
                count++;
            }
            else if  (c == ')') {
                count--;
            }
        }
        return count==0;
    }
    String stripWhitespace(String equation)
    {
        return equation.replace(" ", "");
    }
    // finds the next closing parentheses
    int findClosingParentheses(String equation, int beginning)
    {
        int count = 0;
        for (int i = beginning; i < equation.length(); i++) {
            if(equation.charAt(i) == '(') count++;
            else if(equation.charAt(i) == ')') count--;
            if(count == 0) return i;
        }
        return -1;
    }
}
