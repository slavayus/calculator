package com.job.calculator.commands.two;

/**
 * Class for divide command
 */

public class DivideCommand implements CommandWithTwoArgument {

    /**
     * Divides the first argument into the second.
     *
     * @param dividend first argument that will be divided
     * @param divider  second argument for which we divide
     * @return the result of dividing
     */
    @Override
    public double execute(double dividend, double divider) {
        return dividend / divider;
    }

    /**
     * String representation of the division sign
     *
     * @return UTF char of the division sign
     */
    @Override
    public String toString() {
        return "\u00F7";
    }
}
