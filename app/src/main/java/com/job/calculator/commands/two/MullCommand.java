package com.job.calculator.commands.two;

/**
 * Class for mull command
 */

public class MullCommand implements CommandWithTwoArgument {
    @Override
    public double execute(double result, double currentNumber) {
        return result * currentNumber;
    }

    @Override
    public String toString() {
        return "*";
    }
}
