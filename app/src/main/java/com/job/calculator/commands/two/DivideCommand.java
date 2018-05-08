package com.job.calculator.commands.two;

/**
 * Class for divide command
 */

public class DivideCommand implements CommandWithTwoArgument {
    @Override
    public double execute(double result, double currentNumber) {
        return result / currentNumber;
    }

    @Override
    public String toString() {
        return "\u00F7";
    }
}
