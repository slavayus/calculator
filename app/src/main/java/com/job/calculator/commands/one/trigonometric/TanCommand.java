package com.job.calculator.commands.one.trigonometric;

import static com.job.calculator.Formatter.putComma;

/**
 * Class for tan command
 */

public class TanCommand extends TrigonometricCommand {

    private double result;
    private double currentNumber;

    public TanCommand(boolean inDegrees) {
        super(inDegrees);
    }

    @Override
    public double execute(double currentNumber) {
        this.currentNumber = currentNumber;
        this.result = inDegrees ? Math.tan(Math.toRadians(currentNumber)) : Math.tan(currentNumber);
        return result;
    }

    @Override
    public String toString() {
        return "tan(" + (Math.abs(currentNumber) == Double.POSITIVE_INFINITY ? currentNumber : putComma(String.valueOf(currentNumber))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
