package com.job.calculator.commands.two;

/**
 * Class for minus command
 */

public class MinusCommand implements CommandWithTwoArgument {
    @Override
    public double execute(double result, double currentNumber) {
        return result - currentNumber;
    }

    @Override
    public String toString() {
        return "-";
    }
}
