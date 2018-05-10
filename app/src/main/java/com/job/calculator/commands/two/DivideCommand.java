package com.job.calculator.commands.two;

/**
 * Class for divide command
 */

public class DivideCommand implements CommandWithTwoArgument {

    /**
     * Divides the first argument into the second.
     *
     * @param firstArg  first argument that will be divided
     * @param secondArg second argument for which we divide
     * @return the result of dividing
     */
    @Override
    public double execute(double firstArg, double secondArg) {
        return firstArg / secondArg;
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
