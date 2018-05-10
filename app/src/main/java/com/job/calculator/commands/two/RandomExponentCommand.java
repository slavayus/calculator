package com.job.calculator.commands.two;

/**
 * Class for random exponent command
 */

public class RandomExponentCommand implements CommandWithTwoArgument {

    /**
     * Raises the first number to the power of the second number.
     *
     * @param firstArg  first argument that will be powered
     * @param secondArg the second argument shows the power
     * @return the result of powering
     */
    @Override
    public double execute(double firstArg, double secondArg) {
        return Math.pow(firstArg, secondArg);
    }


    /**
     * String representation of the power sign
     *
     * @return The power sign
     */
    @Override
    public String toString() {
        return "^";
    }
}
