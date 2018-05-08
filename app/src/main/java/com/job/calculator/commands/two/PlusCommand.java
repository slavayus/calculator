package com.job.calculator.commands.two;

/**
 * Class for plus command
 */

public class PlusCommand implements CommandWithTwoArgument {

    @Override
    public double execute(double result, double currentNumber) {
        return result + currentNumber;
    }

    @Override
    public String toString() {
        return "+";
    }
}
