package com.job.calculator.commands.one;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for square command
 */

public class SquareCommand implements CommandWIthSingleArgument {
    private double mResult;
    private double mCurrentNumber;

    /**
     * Calculates the square of an argument
     *
     * @param argument the argument which square will be calculated
     * @return square of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = Math.pow(argument, 2);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                "\n ^ 2 \n = " + (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";
    }
}
