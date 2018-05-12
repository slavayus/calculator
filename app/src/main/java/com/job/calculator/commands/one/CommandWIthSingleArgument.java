package com.job.calculator.commands.one;

/**
 * Interface for commands with one arguments
 */

public interface CommandWIthSingleArgument {

    /**
     * Execute the operation with the received data
     *
     * @param argument the argument for the operation
     * @return result of operation
     */
    double execute(double argument);
}
