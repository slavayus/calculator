package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sqrt command
 */

public class SqrtCommand implements CommandWIthSingleArgument {
    private double mResult;
    private double mCurrentNumber;

    /**
     * Calculates the radical of an argument
     *
     * @param argument the argument which radical will be calculated
     * @return radical of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = Math.sqrt(argument);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return "\u221a " + (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                "\n = " + (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";

    }
}