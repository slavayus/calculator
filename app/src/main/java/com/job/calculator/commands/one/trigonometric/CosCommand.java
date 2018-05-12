package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for cos command
 */

public class CosCommand extends TrigonometricCommand {
    private double mResult;
    private double mCurrentNumber;

    /**
     * Constructor with the argument which shows how to calculate cos.
     *
     * @param inDegrees true - it will be calculated in degrees
     *                   false - it will be calculated in radians
     */
    public CosCommand(boolean inDegrees) {
        super(inDegrees);
    }

    /**
     * Calculates the cos of an argument
     *
     * @param argument the argument which cos will be calculated
     * @return cos of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = mInDegrees ? Math.cos(Math.toRadians(argument)) : Math.cos(argument);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return "cos(" + (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                (mInDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";

    }
}
