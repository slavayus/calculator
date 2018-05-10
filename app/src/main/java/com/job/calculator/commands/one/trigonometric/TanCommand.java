package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for tan command
 */

public class TanCommand extends TrigonometricCommand {

    private double result;
    private double currentNumber;

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
        this.currentNumber = argument;
        this.result = inDegrees ? Math.tan(Math.toRadians(argument)) : Math.tan(argument);
        return result;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted result
     */
    @Override
    public String toString() {
        return "tan(" + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
