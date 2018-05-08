package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for square command
 */

public class SquareCommand implements CommandWIthSingleArgument {
    private double result;
    private double currentNumber;

    @Override
    public double execute(double currentNumber) {
        this.currentNumber = currentNumber;
        this.result = Math.pow(currentNumber, 2);
        return result;
    }

    @Override
    public String toString() {
        return (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                "\n ^ 2 \n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
