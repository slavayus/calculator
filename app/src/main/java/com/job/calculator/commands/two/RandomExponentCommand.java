package com.job.calculator.commands.two;

/**
 * Class for random exponent command
 */

public class RandomExponentCommand implements CommandWithTwoArgument {

    @Override
    public double execute(double result, double currentNumber) {
        return Math.pow(result, currentNumber);
    }

    @Override
    public String toString() {
        return "^";
    }
}
