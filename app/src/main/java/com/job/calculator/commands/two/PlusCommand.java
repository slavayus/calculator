package com.job.calculator.commands.two;

/**
 * Class for plus command
 */

public class PlusCommand implements CommandWithTwoArgument {

    /**
     * Adds two arguments.
     *
     * @param firstArg  first argument for the addition
     * @param secondArg second argument for the addition
     * @return the result of addition
     */
    @Override
    public double execute(double firstArg, double secondArg) {
        return firstArg + secondArg;
    }

    /**
     * String representation of the addition sign
     *
     * @return The addition sign
     */
    @Override
    public String toString() {
        return "+";
    }
}
