package com.job.calculator.commands;

/**
 * Class for minus command
 */

public class MinusCommand implements Command {
    @Override
    public double execute(double result, double currentNumber) {
        return result - currentNumber;
    }

    @Override
    public String toString() {
        return "-";
    }
}
