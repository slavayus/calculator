package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sin command
 */

public class SinCommand extends TrigonometricCommand {
    private double mResult;
    private double mCurrentNumber;

    /**
     * Constructor with the argument which shows how to calculate sin.
     *
     * @param inDegrees true - it will be calculated in degrees
     *                  false - it will be calculated in radians
     */
    public SinCommand(boolean inDegrees) {
        super(inDegrees);
    }

    /**
     * Calculates the sin of an argument
     *
     * @param argument the argument which sin will be calculated
     * @return sin of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = mInDegrees ? Math.sin(Math.toRadians(argument)) : Math.sin(argument);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return "sin(" + (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                (mInDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";

    }
}
