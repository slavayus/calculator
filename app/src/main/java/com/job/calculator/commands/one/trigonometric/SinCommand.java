package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sin command
 */

public class SinCommand extends TrigonometricCommand {
    private double result;
    private double currentNumber;

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
        this.currentNumber = argument;
        this.result = inDegrees ? Math.sin(Math.toRadians(argument)) : Math.sin(argument);
        return result;
    }

    /**
     * Formats the output of the command
     *
     * @return formatted result
     */
    @Override
    public String toString() {
        return "sin(" + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }
}
