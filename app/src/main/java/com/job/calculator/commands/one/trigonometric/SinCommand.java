package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for sin command
 */

public class SinCommand extends TrigonometricCommand {
    private double result;
    private double currentNumber;

    public SinCommand(boolean inDegrees) {
        super(inDegrees);
    }

    @Override
    public double execute(double currentNumber) {
        this.currentNumber = currentNumber;
        this.result = inDegrees ? Math.sin(Math.toRadians(currentNumber)) : Math.sin(currentNumber);
        return result;
    }


    @Override
    public String toString() {
        return "sin(" + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }
}
