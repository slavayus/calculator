package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sqrt command
 */

public class SqrtCommand implements CommandWIthSingleArgument {
    private double result;
    private double currentNumber;

    @Override
    public double execute(double currentNumber) {
        this.currentNumber = currentNumber;
        this.result = Math.sqrt(currentNumber);
        return result;
    }

    @Override
    public String toString() {
        return "\u221a " + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }
}