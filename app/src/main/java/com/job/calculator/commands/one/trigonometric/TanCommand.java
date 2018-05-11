package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for tan command
 */

public class TanCommand extends TrigonometricCommand {

    private double mResult;
    private double mCurrentNumber;

    /**
     * Constructor with the argument which shows how to calculate tan.
     *
     * @param inDegrees true - it will be calculated in degrees
     *                  false - it will be calculated in radians
     */
    public TanCommand(boolean inDegrees) {
        super(inDegrees);
    }

    /**
     * Calculates the tan of an argument
     *
     * @param argument the argument which tan will be calculated
     * @return tan of the argument
     */
    @Override
    public double execute(double argument) {
        this.mCurrentNumber = argument;
        this.mResult = mInDegrees ? Math.tan(Math.toRadians(argument)) : Math.tan(argument);
        return mResult;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted mResult
     */
    @Override
    public String toString() {
        return "tan(" + (Math.abs(mCurrentNumber) == Double.POSITIVE_INFINITY ? mCurrentNumber : putComma(String.valueOf(mCurrentNumber))) +
                (mInDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(mResult) == Double.POSITIVE_INFINITY ? String.valueOf(mResult) : putComma(String.valueOf(mResult))) + "\n\n ";
    }
}
