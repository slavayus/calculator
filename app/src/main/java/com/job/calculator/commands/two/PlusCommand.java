package com.job.calculator.commands.two;

/**
 * Class for plus command
 */

public class PlusCommand implements CommandWithTwoArgument {

    /**
     * Adds two arguments.
     *
     * @param firstNumber  first argument for the addition
     * @param secondNumber second argument for the addition
     * @return the result of addition
     */
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
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
