package com.job.calculator.commands;

/**
 * Class for percent command
 */

public class PercentCommand implements Command {
    @Override
    public double execute(double result, double currentNumber) {
        return result * currentNumber / 100;
    }

    @Override
    public String toString() {
        return "%";
    }
}
