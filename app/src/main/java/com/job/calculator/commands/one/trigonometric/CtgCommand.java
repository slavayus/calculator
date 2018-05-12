package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for ctg command
 */

public class CtgCommand extends TrigonometricCommand {
    private double mResult;
    private double mCurrentNumber;

    /**
     * Constructor with the argument which shows how to calculate ctg.
     *
     * @param inDegrees true - it will be calculated in degrees
     *                  false - it will be calculated in radians
     */
    public CtgCommand(boolean inDegrees) {
        super(inDegrees);
    }

    /**
     * Calculates the ctg of an argument
     *
     * @param argument the argument which ctg will be calculated
     * @return ctg of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = mInDegrees ? 1 / Math.tan(Math.toRadians(argument)) : 1 / Math.tan(argument);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return "ctg(" + (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                (mInDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";

    }
}
