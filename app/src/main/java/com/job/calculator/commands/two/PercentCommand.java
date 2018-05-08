package com.job.calculator.commands.two;

/**
 * Class for percent command
 */

public class PercentCommand implements CommandWithTwoArgument {
    @Override
    public double execute(double result, double currentNumber) {
        return result * currentNumber / 100;
    }

    @Override
    public String toString() {
        return "%";
    }
}
