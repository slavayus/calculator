package com.job.calculator.commands;

/**
 * Interface for commands
 */

public interface Command {
    double execute(double result, double currentNumber);
}
