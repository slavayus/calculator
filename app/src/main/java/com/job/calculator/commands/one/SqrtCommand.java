package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sqrt command
 */

public class SqrtCommand implements CommandWIthSingleArgument {
    private double result;
    private double currentNumber;

    /**
     * Calculates the radical of an argument
     *
     * @param argument the argument which radical will be calculated
     * @return radical of the argument
     */
    @Override
    public double execute(double argument) {
        this.currentNumber = argument;
        this.result = Math.sqrt(argument);
        return result;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted result
     */
    @Override
    public String toString() {
        return "\u221a " + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }
}