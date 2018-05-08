package com.job.calculator.commands.one.trigonometric;

import com.job.calculator.commands.one.CommandWIthSingleArgument;

/**
 * Class for trigonometric command
 */

abstract class TrigonometricCommand implements CommandWIthSingleArgument {
    boolean inDegrees;

    TrigonometricCommand(boolean inDegrees) {
        this.inDegrees = inDegrees;
    }
}
