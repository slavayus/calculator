package com.job.calculator.commands.one.trigonometric;

import com.job.calculator.commands.one.CommandWIthSingleArgument;

/**
 * Class for trigonometric command
 */

abstract class TrigonometricCommand implements CommandWIthSingleArgument {
    boolean mInDegrees;

    /**
     * Constructor with the argument which shows how to calculate the trigonometric command .
     *
     * @param inDegrees true - it will be calculated in degrees
     *                  false - it will be calculated in radians
     */
    TrigonometricCommand(boolean inDegrees) {
        this.mInDegrees = inDegrees;
    }
}
