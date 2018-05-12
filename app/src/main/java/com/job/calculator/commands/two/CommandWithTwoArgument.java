package com.job.calculator.commands.two;

/**
 * Interface for commands with two arguments
 */

public interface CommandWithTwoArgument {

    /**
     * Execute the operation with the received data
     *
     * @param firstArg  the first argument for the operation
     * @param secondArg the second argument for the operation
     * @return result of operation
     */
    double execute(double firstArg, double secondArg);
}
