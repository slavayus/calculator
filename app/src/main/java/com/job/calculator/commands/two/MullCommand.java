package com.job.calculator.commands.two;

/**
 * Class for mull command
 */

public class MullCommand implements CommandWithTwoArgument {

    /**
     * Multiplies the first argument by the second.
     *
     * @param firstArg  first argument for the multiplication
     * @param secondArg second argument for the multiplication
     * @return the result of multiplication
     */
    @Override
    public double execute(double firstArg, double secondArg) {
        return firstArg * secondArg;
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
