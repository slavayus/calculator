package com.job.calculator;

import com.job.calculator.commands.two.CommandWithTwoArgument;

/**
 * Class for formatting the text
 */

public class Formatter {
    private static final char DIGIT_SEPARATOR = ',';

    public static String putComma(String number) {
        StringBuilder textWithComma = new StringBuilder(number);
        int lastChar = number.length() > 0 && '-' == (number.charAt(0)) ? 1 : 0;
        int firstChar = number.indexOf('.') != -1 ? number.indexOf('.') - 3 : number.length() - 3;
        for (int i = firstChar; i > lastChar; i -= 3) {
            textWithComma.insert(i, DIGIT_SEPARATOR);
        }

        return textWithComma.toString();
    }

    static String appentText(String dataInTextView, double result, CommandWithTwoArgument command, String currentNumber) {
        return dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n " +
                (command != null ? command : "") + " " +
                (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber));
    }


    static double getCurrentNumberAsNumber(String currentNumber) {
        return "".equals(currentNumber) ? 0 : Double.parseDouble(currentNumber);
    }

    static String getAsNewResult(String dataInTextView, double result, CommandWithTwoArgument command) {
        return dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n" + (command == null ? "" : command);
    }

    static String getAsEqual(double previousResult, String currentNumber, double result, CommandWithTwoArgument command) {
        return (Math.abs(previousResult) == Double.POSITIVE_INFINITY ? String.valueOf(previousResult) : putComma(String.valueOf(previousResult))) +
                "\n " + command + " " +
                (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
