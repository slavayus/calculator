package com.job.calculator.commands.two;

/**
 * Class for mull command
 */

public class MullCommand implements CommandWithTwoArgument {

    /**
     * Multiplies the first argument by the second.
     *
     * @param multiplicand  first argument for the multiplication
     * @param multiplier second argument for the multiplication
     * @return the result of multiplication
     */
    @Override
    public double execute(double multiplicand, double multiplier) {
        return multiplicand * multiplier;
    }

    /**
     * String representation of the multiplication sign
     *
     * @return multiplication sign
     */
    @Override
    public String toString() {
        return "*";
    }
}
