package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for square command
 */

public class SquareCommand implements CommandWIthSingleArgument {
    private double result;
    private double currentNumber;

    /**
     * Calculates the square of an argument
     *
     * @param argument the argument which square will be calculated
     * @return square of the argument
     */
    @Override
    public double execute(double argument) {
        this.currentNumber = argument;
        this.result = Math.pow(argument, 2);
        return result;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted result
     */
    @Override
    public String toString() {
        return (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                "\n ^ 2 \n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
