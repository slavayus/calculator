package com.job.calculator.commands;

/**
 * Class for random exponent command
 */

public class RandomExponentCommand implements Command {

    @Override
    public double execute(double result, double currentNumber) {
        return Math.pow(result, currentNumber);
    }

    @Override
    public String toString() {
        return "^";
    }
}
