package com.imshy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Formula form = new Formula();
        Tools tools = new Tools();
        String formula = "(2+2*2)*(4+3)";
        String[] vals = formula.split("[+\\-*/]");
        System.out.println(form.solve(formula));
    }
}
