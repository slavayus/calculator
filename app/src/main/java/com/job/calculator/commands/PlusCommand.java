package com.job.calculator.commands;

/**
 * Class for plus command
 */

public class PlusCommand implements Command {

    @Override
    public double execute(double result, double currentNumber) {
        return result + currentNumber;
    }

    @Override
    public String toString() {
        return "+";
    }
}
