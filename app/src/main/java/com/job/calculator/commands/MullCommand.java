package com.job.calculator.commands;

/**
 * Class for mull command
 */

public class MullCommand implements Command {
    @Override
    public double execute(double result, double currentNumber) {
        return result * currentNumber;
    }

    @Override
    public String toString() {
        return "*";
    }
}
